package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class GameScreen : AppCompatActivity() {
    companion object{
        val EXTRA_GAME = "game"
        @SuppressLint("StaticFieldLeak")
        var gameContext: Context? = null
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameContext = this
        setContentView(GamePanel(this))
        Log.d("GameScreen", "onCreate: Started gameScreen")


    }



}