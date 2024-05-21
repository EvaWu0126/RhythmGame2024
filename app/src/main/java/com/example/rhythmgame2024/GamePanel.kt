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

    // beatList is not initialized??
    private lateinit var beatList : MutableList<PointF>



    init {
        holder.addCallback(this)
        redPaint.color = Color.RED
//        makeBeats()

        var x : Float = 0F
        for(row in rawBeat.indices) {
            for (col in rawBeat[row].indices) {
                if(rawBeat[row][col] == 1){
                    if(col == 0){
                        x = 240F
                    }else if(col == 1){
                        x = 540F
                    }else if(col == 2){
                        x = 840F
                    }else if(col == 3){
                        x = 1140F
                    }else if(col == 4){
                        x = 1440F
                    }else if(col == 5){
                        x = 1740F
                    }
                }
                beatList.add(PointF(x, 0F))
            }
        }
        Log.d("TAG", "Init: ${beatList}")


    }

    fun makeBeats() {
        Log.d("gamepanel", "is canvas null?: ${holder.lockCanvas()} ")
        //gameloop = GameLoop(this)


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

        Log.d("beat", "rende_rawBeat: ${rawBeat}")
        for(row in rawBeat.indices) {
            Log.d("beat", "render_row: ${row}")
            for (col in rawBeat[row].indices) {
                Log.d("beat", "render_col: ${col}")
                if(rawBeat[row][col] == 1){
                    if(col == 0){
                        c.drawBitmap(GameBeats.BEAT1.beats, 240F, 0F, null)
                        Log.d("beat", "render: beat 1")
                    }else if(col == 1){
                        c.drawBitmap(GameBeats.BEAT2.beats, 540F, 0F, null)
                        Log.d("beat", "render: beat 2")
                    }else if(col == 2){
                        c.drawBitmap(GameBeats.BEAT3.beats, 840F, 0F, null)
                        Log.d("beat", "render: beat 3")
                    }else if(col == 3){
                        c.drawBitmap(GameBeats.BEAT4.beats, 1140F, 0F, null)
                        Log.d("beat", "render: beat 4")
                    }else if(col == 4){
                        c.drawBitmap(GameBeats.BEAT5.beats, 1440F, 0F, null)
                        Log.d("beat", "render: beat 5")
                    }else if(col == 5){
                        c.drawBitmap(GameBeats.BEAT6.beats, 1740F, 0F, null)
                        Log.d("beat", "render: beat 6")
                    }
                }
            }
        }



        // draw text function
        //c.drawText("Flos", 100F,100F, redPaint)

        holder.unlockCanvasAndPost(c)

    }

//    fun update(delta: Int){
//        for (pos in beatList.indices) {
//            (pos.y += delta * 300).toFloat()
//            if (pos.y >= 1500) {
//                pos.y = 0f
//            }
//
//        }
//    }



    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        render(0F)
        //update(20)
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