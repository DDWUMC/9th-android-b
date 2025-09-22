package com.UMC_9th.jini

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.UMC_9th.jini.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val songActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == Activity.RESULT_OK) {

            val data = result.data
            if (data != null) {

                val message = data.getStringExtra("album_title")
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainPlayerCl.setOnClickListener {

            val intent = Intent(this, SongActivity::class.java)

            intent.putExtra("title", binding.mainMiniplayerTitleTv.text.toString())
            intent.putExtra("singer", binding.mainMiniplayerSingerTv.text.toString())

            songActivityLauncher.launch(intent)
        }
    }
}