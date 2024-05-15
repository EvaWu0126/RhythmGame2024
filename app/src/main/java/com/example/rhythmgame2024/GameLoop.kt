package com.example.rhythmgame2024

import android.util.Log
import kotlin.math.log

class GameLoop(gamePanel: GamePanel) : Runnable{
    private lateinit var gamePanel : GamePanel
    private val gameThread: Thread = Thread(this)


    override fun run() {
        while (true){
            Log.d("GameLoop", "run: gameLoop rendering")
            gamePanel.render()
        }
    }

    fun startGameLoop(){
        gameThread!!.start()
        Log.d("GameLoop", "startGameLoop: true")
    }
}
