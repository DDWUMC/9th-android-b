package com.mobile.week01_danu

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        findViewById<ImageView>(R.id.ivFeel1).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvFeel1)
            text.setTextColor(Color.parseColor("#FFEFB6"))
            Toast.makeText(this, "1번 감정을 선택했습니다.", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivFeel2).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvFeel2)
            text.setTextColor(Color.parseColor("#CEE7F5"))
            Toast.makeText(this, "2번 감정을 선택했습니다.", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivFeel3).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvFeel3)
            text.setTextColor(Color.parseColor("#BEC3ED"))
            Toast.makeText(this, "3번 감정을 선택했습니다.", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivFeel4).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvFeel4)
            text.setTextColor(Color.parseColor("#B1D3B9"))
            Toast.makeText(this, "4번 감정을 선택했습니다.", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivFeel5).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvFeel5)
            text.setTextColor(Color.parseColor("#EB8B8B"))
            Toast.makeText(this, "5번 감정을 선택했습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}