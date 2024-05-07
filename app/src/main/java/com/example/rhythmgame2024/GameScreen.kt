package com.example.rhythmgame2024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(GamePanel(this));


    }

}