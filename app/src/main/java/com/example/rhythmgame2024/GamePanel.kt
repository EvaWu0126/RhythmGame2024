package com.example.rhythmgame2024

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView

class GamePanel(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private val redPaint = Paint()

    init {
        holder.addCallback(this)
        redPaint.color = Color.RED
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        val c = surfaceHolder.lockCanvas()
        c.drawRect(50f, 50f, 100f, 100f, redPaint)
        surfaceHolder.unlockCanvasAndPost(c)
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {}
    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {}
}