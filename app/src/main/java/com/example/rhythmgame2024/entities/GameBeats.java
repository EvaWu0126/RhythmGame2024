package com.example.rhythmgame2024.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.util.Log;

import com.example.rhythmgame2024.GameScreen;
import com.example.rhythmgame2024.R;

public enum GameBeats {

    BEAT1(R.drawable.beats),
    BEAT2(R.drawable.beats),
    BEAT3(R.drawable.beats),
    BEAT4(R.drawable.beats),
    BEAT5(R.drawable.beats),
    BEAT6(R.drawable.beats),
    BEATTAP1(R.drawable.tap_beat_check),
    BEATTAP2(R.drawable.tap_beat_check),
    BEATTAP3(R.drawable.tap_beat_check),
    BEATTAP4(R.drawable.tap_beat_check),
    BEATTAP5(R.drawable.tap_beat_check),
    BEATTAP6(R.drawable.tap_beat_check),
    LINE1(R.drawable.line),
    LINE2(R.drawable.line),
    LINE3(R.drawable.line),
    LINE4(R.drawable.line),
    LINE5(R.drawable.line),
    LINE6(R.drawable.line);

    private Bitmap beats;
    private Bitmap tapCheck;
    private Bitmap line;
    private BitmapFactory.Options options = new BitmapFactory.Options();

    GameBeats(int resID) {
        beats = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        beats = getScaledBitmap(beats, 0.65, 0.65);
        tapCheck = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        tapCheck = getScaledBitmap(tapCheck, 0.4,0.4);
        line = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        line = getScaledBitmap(line, 0.2,7);

    }

    public Bitmap getBeats(){
        return beats;
    }

    public Bitmap getTapCheck(){
        return tapCheck;
    }

    public Bitmap getLine(){
        return line;
    }

    private Bitmap getScaledBitmap(Bitmap bitmap, double w, double h){
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * w), (int) (bitmap.getHeight() * h), false);
    }
}
