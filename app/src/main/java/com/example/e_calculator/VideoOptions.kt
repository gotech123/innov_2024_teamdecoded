package com.example.e_calculator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class VideoOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_options)

        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.videomain)
        videoView.setVideoURI(videoUri)
        videoView.start()
        videoView.setOnCompletionListener {
            videoView.start()
        }

        val loginbtn = findViewById<Button>(R.id.button)
        val signupbtn = findViewById<Button>(R.id.button4)

        loginbtn.setOnClickListener {
            intent = Intent(this,Login_Page::class.java)
            startActivity(intent)
        }

        signupbtn.setOnClickListener {
            intent = Intent(this,SignUp_Page::class.java)
            startActivity(intent)
        }
    }
}