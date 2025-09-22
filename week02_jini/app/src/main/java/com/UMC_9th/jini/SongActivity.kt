package com.UMC_9th.jini

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.UMC_9th.jini.databinding.ActivitySongBinding // 자신의 바인딩 파일 이름으로 변경

class SongActivity : AppCompatActivity() {

    lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songDownIb.setOnClickListener {
            exit()
        }
    }

    private fun exit() {
        val returnIntent = Intent()

        returnIntent.putExtra("album_title", "LILAC")

        setResult(Activity.RESULT_OK, returnIntent)

        if (!isFinishing) finish()
    }
}