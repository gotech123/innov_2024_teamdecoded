package com.example.e_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.e_calculator.databinding.ActivityLoginPageBinding
import com.example.e_calculator.databinding.ActivitySignUpPageBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp_Page : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back = findViewById<ImageButton>(R.id.backbtn)
        val page = findViewById<TextView>(R.id.textView6)

        auth = FirebaseAuth.getInstance()


        back.setOnClickListener {
            intent = Intent(this,VideoOptions::class.java)
            startActivity(intent)
        }

        page.setOnClickListener {
            intent = Intent(this,Login_Page::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {

            val name = binding.editTextText.text.toString()
            val lastname = binding.editTextText1.text.toString()
            val email = binding.editTextText2.text.toString()
            val pass = binding.editTextText3.text.toString()

            if (name.isNotEmpty() && lastname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        intent = Intent(this,Login_Page::class.java)
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