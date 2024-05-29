package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Rect
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.rhythmgame2024.entities.GameBeats
import kotlinx.coroutines.delay
import java.util.logging.Handler


class GamePanel(context: Context?, beatmap : List<List<Int>>, songName : String) : SurfaceView(context), SurfaceHolder.Callback {
    private val redPaint = Paint()
    private val whitePaint = Paint()
    private var holder: SurfaceHolder = getHolder()
    private var gameloop: GameLoop
    private var name : String = songName
    var highCombo : Int = 0

    var didGameEnd : Boolean = true

    private var currentRow : Int = 0
    private val rawBeat : List<List<Int>> = beatmap
    private var beatList : MutableList<PointF> = mutableListOf<PointF>()



    init {
        holder.addCallback(this)

        redPaint.color = Color.RED
        whitePaint.color = Color.WHITE
        var textSize : Float = whitePaint.textSize
        whitePaint.textSize = textSize*5

        gameloop = GameLoop(this)


        beatListUpdate()
        Log.d("test", "testing: ${rawBeat}")
    }


    // method handle screen render
    public fun render(left : Float){


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

        for(pos in beatList) {
            //Log.d("beat", "rende_rawBeat: ${rawBeat}")
            for (col in rawBeat[currentRow].indices) {
                //Log.d("beat", "render_col: ${col}")
                if (rawBeat[currentRow][col] == 1) {
                    if (col == 0) {
                        c.drawBitmap(GameBeats.BEAT1.beats, 240F, pos.y, null)
                        Log.d("Render Beats", "render: ${pos.y}")
                    } else if (col == 1) {
                        c.drawBitmap(GameBeats.BEAT2.beats, 540F, pos.y, null)
                    } else if (col == 2) {
                        c.drawBitmap(GameBeats.BEAT3.beats, 840F, pos.y, null)
                    } else if (col == 3) {
                        c.drawBitmap(GameBeats.BEAT4.beats, 1140F, pos.y, null)
                    } else if (col == 4) {
                        c.drawBitmap(GameBeats.BEAT5.beats, 1440F, pos.y, null)
                    } else if (col == 5) {
                        c.drawBitmap(GameBeats.BEAT6.beats, 1740F, pos.y, null)
                    }
                }
            }
        }




        // draw text function
        c.drawText(name, 100F,100F, whitePaint)

        holder.unlockCanvasAndPost(c)
    }

    fun update(delta: Float){
        for (i in beatList.indices) {
            var pos = beatList[i]
            pos.y += delta * 30
            Log.d("pos", "update: ${beatList}")

            if (pos.y >= 1080) {
                currentRow ++
                Log.d("update", "update: ${currentRow}")
                beatListUpdate();
            }
        }

        if(currentRow >= rawBeat.size-1){
            Log.d("end", "update: ${rawBeat.size}")
            gameloop.endGameLoop()
            didGameEnd = true
        }

    }

    fun beatListUpdate(){
        beatList.clear()
        var x : Float = 0F
        for (col in rawBeat[currentRow].indices) {
            if(rawBeat[currentRow][col] == 1){
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
            beatList.add(PointF(x, -50F))
        }
        Log.d("TAG", "Init: ${beatList}")
        Log.d("TAG", "Init: ${beatList.count()}")
    }



    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        gameloop.startGameLoop()
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