package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.rhythmgame2024.entities.GameBeats

class GamePanel(context: Context?, beatmap : List<List<Int>>) : SurfaceView(context), SurfaceHolder.Callback {
    private val redPaint = Paint()
    private val holder: SurfaceHolder = getHolder()
    //private var gameloop: GameLoop

    private val beatmap : List<List<Int>> = beatmap


    init {
        holder.addCallback(this)
        redPaint.color = Color.RED

        //gameloop = GameLoop(this)

        for(row in beatmap) {
            for (col in row) {
                if(col == 1){

                }
            }
        }
    }

    // method handle screen render
    fun render() {
        val c : Canvas = holder.lockCanvas()
        c.drawColor(Color.BLACK)

        c.drawBitmap(GameBeats.LINE1.line, 300F,-730F,null)
        c.drawBitmap(GameBeats.LINE2.line, 600F,-730F,null)
        c.drawBitmap(GameBeats.LINE3.line, 900F,-730F,null)
        c.drawBitmap(GameBeats.LINE4.line, 1200F,-730F,null)
        c.drawBitmap(GameBeats.LINE5.line, 1500F,-730F,null)
        c.drawBitmap(GameBeats.LINE6.line, 1800F,-730F,null)
        c.drawBitmap(GameBeats.BEATTAP1.tapCheck, 270F,730F,null)
        c.drawBitmap(GameBeats.BEATTAP2.tapCheck, 570F,730F,null)
        c.drawBitmap(GameBeats.BEATTAP3.tapCheck, 870F,730F,null)
        c.drawBitmap(GameBeats.BEATTAP4.tapCheck, 1170F,730F,null)
        c.drawBitmap(GameBeats.BEATTAP5.tapCheck, 1470F,730F,null)
        c.drawBitmap(GameBeats.BEATTAP6.tapCheck, 1770F,730F,null)


        holder.unlockCanvasAndPost(c)
    }



    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        render()
//        gameloop.startGameLoop()
//        Log.d("GamePanel", "GamePanel: gameloop activated")
    }

    // method handle user touch screen
    @SuppressLint("SuspiciousIndentation")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event?.getAction() == MotionEvent.ACTION_DOWN)


        Log.d("GamePanel", "onTouchEvent: user Touch")
        return true
    }



    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {}
    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {}
}