package com.example.mypingoceanapplication

data class LoginResponse(
    val token: String,
    val sections: List<String>
)
