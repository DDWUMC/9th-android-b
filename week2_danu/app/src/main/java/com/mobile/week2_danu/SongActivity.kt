package com.mobile.week2_danu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mobile.week2_danu.databinding.ActivitySongBinding


class SongActivity : AppCompatActivity() {
    lateinit var binding : ActivitySongBinding
    private val ALBUM_TITLE_TO_RETURN = "라일락 (The Lilac Album)"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()
        setDummyUI()
        initClickListener()
    }

    private fun getIntentData() {
        val title = intent.getStringExtra("TITLE")
        val singer = intent.getStringExtra("SINGER")

        if (title != null) {
            binding.songMusicTitleTv.text = title
        }
        if (singer != null) {
            binding.songSingerNameTv.text = singer
        }
    }

    private fun setDummyUI() {
        binding.songMusicTitleTv.text = "UI 구현용 제목"
        binding.songSingerNameTv.text = "UI 구현용 가수 이름"
        binding.songStartTimeTv.text = "00:00"
        binding.songEndTimeTv.text = "03:45"

        binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off)

        binding.songMiniplayerIv.visibility = View.VISIBLE
        binding.songPauseIv.visibility = View.GONE
    }

    private fun initClickListener(){
        binding.songDownIb.setOnClickListener {
            returnResultToMainActivity()
        }

        binding.songMiniplayerIv.setOnClickListener {
            togglePlayStatus(true)
        }

        binding.songPauseIv.setOnClickListener {
            togglePlayStatus(false)
        }

        binding.songLikeIv.setOnClickListener {
            toggleLikeStatus()
        }

        binding.songNextIv.setOnClickListener { /* UI만 구현 */ }
        binding.songPreviousIv.setOnClickListener { /* UI만 구현 */ }
    }

    private fun returnResultToMainActivity() {
        val resultIntent = Intent()
        resultIntent.putExtra("ALBUM_TITLE", ALBUM_TITLE_TO_RETURN)
        setResult(RESULT_OK, resultIntent)

        finish()
    }

    private fun togglePlayStatus (isPlaying : Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        } else {
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
    }

    private fun toggleLikeStatus() {
        val isCurrentlyLiked = binding.songLikeIv.tag == "liked"

        if (isCurrentlyLiked) {
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_off)
            binding.songLikeIv.tag = "unliked"
        } else {
            binding.songLikeIv.setImageResource(R.drawable.ic_my_like_on)
            binding.songLikeIv.tag = "liked"
        }
    }
}