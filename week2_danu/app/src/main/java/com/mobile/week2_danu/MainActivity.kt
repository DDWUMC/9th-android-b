package com.mobile.week2_danu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobile.week2_danu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val songActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val returnedTitle = result.data?.getStringExtra("ALBUM_TITLE")
            if (returnedTitle != null) {
                Toast.makeText(this, "SongActivity에서 받은 앨범 제목: $returnedTitle", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFrm.id, HomeFragment())
            .commitAllowingStateLoss()

        initBottomNavigation()

        binding.mainPlayerCl.setOnClickListener {
            startSongActivity()
        }
    }

    private fun startSongActivity() {
        val intent = Intent(this, SongActivity::class.java)

        val title = binding.mainMiniplayerTitleTv.text.toString()
        val singer = binding.mainMiniplayerSingerTv.text.toString()

        intent.putExtra("TITLE", title)
        intent.putExtra("SINGER", singer)

        songActivityResultLauncher.launch(intent)
    }

    private fun initBottomNavigation() {
        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId){

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.mainFrm.id, HomeFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}