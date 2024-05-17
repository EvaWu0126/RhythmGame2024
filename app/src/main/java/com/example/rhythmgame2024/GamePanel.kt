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
    private var holder: SurfaceHolder = getHolder()
    //private var gameloop: GameLoop

    private val rawBeat : List<List<Int>> = beatmap


    init {
        holder.addCallback(this)
        redPaint.color = Color.RED
//        makeBeats()


    }

    fun makeBeats() {
        Log.d("gamepanel", "is canvas null?: ${holder.lockCanvas()} ")
        //gameloop = GameLoop(this)


        // beatmap tracing
        var x : Float = 0F
        for(row in rawBeat) {
            for (col in row) {
                if(row[col] == 1){
                    if(col == 1){
                        x = 270F
                    }else if(col == 2){
                        x = 570F
                    }else if(col == 3){
                        x = 870F
                    }else if(col == 4){
                        x = 1170F
                    }else if(col == 5){
                        x = 1470F
                    }else if(col == 6){
                        x = 1770F
                    }
                    render(x)
                }
            }
        }
    }

    // method handle screen render
    fun render(left : Float){
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

        c.drawBitmap(GameBeats.BEAT.beats, left, 0F, null)

        // draw text function
        //c.drawText("Flos", 100F,100F, redPaint)

        holder.unlockCanvasAndPost(c)
    }



    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        render(x)
//        gameloop.startGameLoop()
        Log.d("GamePanel", "GamePanel: surfacecreated")
//        makeBeats()

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