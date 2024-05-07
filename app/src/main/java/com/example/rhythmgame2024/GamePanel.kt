package com.example.rhythmgame2024

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GamePanel(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private val redPaint = Paint()
    private val holder: SurfaceHolder = getHolder()
    //private var x : Float = 0.0f
    //private var y : Float = 0.0f
    private var squarePos : ArrayList<PointF> = arrayListOf()

    private lateinit var gameLoop : GameLoop


    init {
        holder.addCallback(this)
        redPaint.color = Color.RED

        //gameLoop = GameLoop(this)
    }

    // method handle screen render
    public fun render() {
        val c = holder.lockCanvas()
        c.drawColor(Color.BLACK)

        for (pos in squarePos)
            c.drawRect(pos.x, pos.y, pos.x + 50, pos.y + 50, redPaint)
            Log.d("GamePanel", "return $squarePos")

        holder.unlockCanvasAndPost(c)
    }

//    public fun update(){
//        square.move()
//    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        //gameLoop.startGameLoop()
    }

    // method handle user touch screen
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event != null) {
            squarePos.add(PointF(event.x, event.y))
        }

        render()

        Log.d("GamePanel", "onTouchEvent: user Touch")
        return true
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {}
    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {}
}