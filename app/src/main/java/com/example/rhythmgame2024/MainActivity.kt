package com.example.rhythmgame2024

import android.R
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rhythmgame2024.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : GameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
//        to start music
//        val music: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.music)
//        music.start()
        val inputStream = resources.openRawResource(R.raw.info)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "onCreate: jsonString $jsonString")
        val gson = Gson()
        val qType = object : TypeToken<List<Features>>() {}.type
        val songInfo = gson.fromJson<List<Features>>(jsonString, qType)
        Log.d(TAG, "onCreate: $songInfo")

        //link the adapter to the recyclerview and give it the list
        adapter = GameAdapter(songInfo)
        binding.recyclerViewMainSongList.adapter = adapter
        binding.recyclerViewMainSongList.layoutManager = LinearLayoutManager(this)

    }


}