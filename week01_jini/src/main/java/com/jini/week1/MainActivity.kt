package com.jini.week1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val happyImage = findViewById<ImageView>(R.id.happy_image)
        val happyText = findViewById<TextView>(R.id.happy)
        val excitingImage = findViewById<ImageView>(R.id.exciting_image)
        val excitingText = findViewById<TextView>(R.id.exciting)
        val normalImage = findViewById<ImageView>(R.id.normal_image)
        val normalText = findViewById<TextView>(R.id.normal)
        val anxietyImage = findViewById<ImageView>(R.id.anxiety_image)
        val anxietyText = findViewById<TextView>(R.id.anxiety)
        val angryImage = findViewById<ImageView>(R.id.angry_image)
        val angryText = findViewById<TextView>(R.id.angry)

        happyImage.setOnClickListener {
            happyText.setTextColor("#FFEFB6".toColorInt())
            Toast.makeText(this, "Great!", Toast.LENGTH_SHORT).show()
        }
        excitingImage.setOnClickListener {
            excitingText.setTextColor("#CEE7F5".toColorInt())
            Toast.makeText(this, "Nice", Toast.LENGTH_SHORT).show()
        }
        normalImage.setOnClickListener {
            normalText.setTextColor("#BEC3ED".toColorInt())
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
        }
        anxietyImage.setOnClickListener {
            anxietyText.setTextColor("#B1D3B9".toColorInt())
            Toast.makeText(this, "Oh", Toast.LENGTH_SHORT).show()
        }
        angryImage.setOnClickListener {
            angryText.setTextColor("#EB8B8B".toColorInt())
            Toast.makeText(this, "Relax", Toast.LENGTH_SHORT).show()
        }



    }
}
