package com.example.mypingoceanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    lateinit var logoutBtn: Button
    lateinit var idTv: TextView
    lateinit var nameTv: TextView
    lateinit var emailTv: TextView
    lateinit var phoneTv: TextView
    lateinit var avatarTv: TextView
    lateinit var positionTv: TextView
    lateinit var comNameTv: TextView
    lateinit var timezoneTv: TextView
    lateinit var sectionsTv: TextView
    lateinit var alertEmailTv: TextView
    lateinit var sendSysNotTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        logoutBtn = findViewById(R.id.Logout)
        idTv = findViewById(R.id.idText)
        nameTv = findViewById(R.id.nameText)
        emailTv = findViewById(R.id.emailText)
        phoneTv = findViewById(R.id.phoneText)
        avatarTv = findViewById(R.id.avatarText)
        positionTv = findViewById(R.id.positionText)
        comNameTv = findViewById(R.id.companyNameText)
        timezoneTv = findViewById(R.id.timezoneText)
        sectionsTv = findViewById(R.id.sectionText)
        alertEmailTv = findViewById(R.id.alertEmailText)
        sendSysNotTv = findViewById(R.id.sendSystemNotificationsText)

        val profile = intent.extras?.getParcelable<ProfileResponse>(MainActivity.PROFILE)

        idTv.text = profile?.id.toString()
        nameTv.text = profile?.name.toString()
        emailTv.text = profile?.email.toString()
        phoneTv.text = profile?.phone.toString()
        avatarTv.text = profile?.avatar.toString()
        positionTv.text = profile?.position.toString()
        comNameTv.text = profile?.company_name.toString()
        timezoneTv.text = profile?.timezone.toString()
        sectionsTv.text = profile?.sections.toString()
        alertEmailTv.text = profile?.alert_email.toString()
        sendSysNotTv.text = profile?.send_system_notifications.toString()

        logoutBtn.setOnClickListener {
            finish()
        }
    }
}