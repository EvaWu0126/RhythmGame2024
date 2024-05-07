package com.example.rhythmgame2024

import android.util.Log
import kotlin.math.log

class GameLoop(gamePanel: GamePanel) : Runnable{

    lateinit var gameThread: Thread
    lateinit var gamePanel : GamePanel

    public fun Gameloop(gamePanel: GamePanel) {
        this.gamePanel = gamePanel
        gameThread = Thread(this)
    }

    override fun run() {
        while (true){
            Log.d("GameLoop", "run: gameLoop rendering")
            gamePanel.render()
        }
    }

    public fun startGameLoop(){
        gameThread!!.start()
        Log.d("GameLoop", "startGameLoop: true")
    }
}
