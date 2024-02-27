package com.example.e_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class SignUp_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val back = findViewById<ImageButton>(R.id.backbtn)
        val page = findViewById<TextView>(R.id.textView6)

        back.setOnClickListener {
            intent = Intent(this,VideoOptions::class.java)
            startActivity(intent)
        }

        page.setOnClickListener {
            intent = Intent(this,Login_Page::class.java)
            startActivity(intent)
        }
    }
}