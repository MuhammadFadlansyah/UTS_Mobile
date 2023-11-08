package com.fadlan.airquality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val daftar = findViewById<Button>(R.id.btnsignup)
        daftar.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        val kembali = findViewById<TextView>(R.id.btnkembali)
        kembali.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}