package com.example.rhythmgame2024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameScreen : AppCompatActivity() {
    companion object{
        val EXTRA_GAME = "game"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(GamePanel(this));


    }

}