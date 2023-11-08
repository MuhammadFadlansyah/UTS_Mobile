package com.fadlan.airquality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.btnlogin)
        login.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val register = findViewById<TextView>(R.id.btnregister)
        register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        val forgot = findViewById<TextView>(R.id.btnforgot)
        forgot.setOnClickListener {
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
        }
    }
}