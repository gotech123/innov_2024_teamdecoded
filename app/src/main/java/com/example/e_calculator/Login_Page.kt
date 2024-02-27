package com.example.e_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val back=findViewById<ImageButton>(R.id.backbtn)

        back.setOnClickListener{
            intent= Intent(this,VideoOptions::class.java)
            startActivity(intent)
        }
    }
}