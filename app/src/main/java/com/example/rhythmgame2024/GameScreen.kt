package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
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
            Log.d("gameScreen", "onCreate: MediaPlayer is playing")
            setContentView(GamePanel(this, rhythmGame.beatmap, rhythmGame.name, rhythmGame.fileName))
        }
        Log.d("GameScreen", "onCreate: Started gameScreen")
        Log.d("GameScreen", "onCreate: ${rhythmGame?.beatmap}")

        var highCombo : Int? = rhythmGame?.let { GamePanel(this, it.beatmap,rhythmGame.name, rhythmGame.fileName).highCombo }

        if (rhythmGame != null) {
            if(GamePanel(this, rhythmGame.beatmap,rhythmGame.name,rhythmGame.fileName).didGameEnd == true){

//                val detailIntent = Intent(gameContext, EndScreen::class.java)
//                detailIntent.putExtra(GameScreen.EXTRA_GAME, rhythmGame)
//                (gameContext as GameScreen).startActivity(detailIntent)
//                Log.d("gameScreen", "onCreate: game ended")
            }
        }


    }



}