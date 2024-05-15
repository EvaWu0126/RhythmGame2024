package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GameScreen : AppCompatActivity() {
    companion object{
        val EXTRA_GAME = "game"
        @SuppressLint("StaticFieldLeak")
        var gameContext: Context? = null
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rhythmGame = intent.getParcelableExtra<Features>(EXTRA_GAME)
        gameContext = this
        if (rhythmGame != null) {
            setContentView(GamePanel(this, rhythmGame.beatmap))
        }
        Log.d("GameScreen", "onCreate: Started gameScreen")




    }



}