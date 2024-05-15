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

class GamePanel(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private val redPaint = Paint()
    private val holder: SurfaceHolder = getHolder()
    //private var gameloop: GameLoop


    init {
        holder.addCallback(this)
        redPaint.color = Color.RED

        //gameloop = GameLoop(this)
    }

    // method handle screen render
    fun render() {
        val c : Canvas = holder.lockCanvas()
        c.drawColor(Color.BLACK)

        c.drawBitmap(GameBeats.BEAT.beats, 400F, 0F, null)
        c.drawBitmap(GameBeats.BEATTAP.tapCheck, 380F,700F,null)
        c.drawBitmap(GameBeats.LINE.line, 350F,100F,null)

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