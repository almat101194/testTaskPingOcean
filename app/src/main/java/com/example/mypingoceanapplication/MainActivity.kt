package com.example.mypingoceanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = " https://dev-api.ringapp.me/"

class MainActivity : AppCompatActivity() {
    companion object{
        const val PROFILE = "profile"
    }

    val TAG = "Activity"
    lateinit var tokenAccess: String
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextEmail = findViewById(R.id.emailField)
        editTextPassword = findViewById(R.id.passwordField)
        loginBtn = findViewById(R.id.Login)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        intent = Intent(this, ProfileActivity::class.java)

        loginBtn.setOnClickListener {
            if (editTextEmail.text.toString() == "testalina@mailsecv.com" && editTextPassword.text.toString() == "1q2w3e4r5t") {
                toLogin(api, editTextEmail.text.toString(), editTextPassword.text.toString())
            }else {
                Toast.makeText(this, "Не правильный пороль или логин", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun moveToProfile(intent: Intent, profileResponse:Response<ProfileResponse> ) {
        intent.putExtra(PROFILE, profileResponse.body()!!)
        startActivity(intent)
    }

     suspend fun getProfile(api: MyApi, response: Response<LoginResponse>) {
        val profresponse = api.getProfile("Bearer ${response.body()!!.token}")
        if (profresponse.isSuccessful) {
            Log.d(TAG, profresponse.body()!!.id.toString())
            moveToProfile(intent, profresponse)
        }
    }

    fun toLogin(api: MyApi, email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getToken(Login(editTextEmail.text.toString(), editTextPassword.text.toString()))
            if (response.isSuccessful) {
                tokenAccess = response.body()!!.token
                Log.d(TAG, tokenAccess.toString())

                getProfile(api, response)
            }
        }
    }
}