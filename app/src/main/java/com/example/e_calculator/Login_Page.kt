package com.example.e_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.e_calculator.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Page : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    private lateinit var binding :ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val back=findViewById<ImageButton>(R.id.backbtn)
        val page=findViewById<TextView>(R.id.txt)

        page.setOnClickListener{
            intent= Intent(this,SignUp_Page::class.java)
            startActivity(intent)
        }

        back.setOnClickListener{
            intent= Intent(this,VideoOptions::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {

            val email = binding.editTextText.text.toString()
            val pass = binding.editTextText1.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){

                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        intent = Intent(this,HomeScreen::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this,"Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}