package com.example.rhythmgame2024.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.util.Log;

import com.example.rhythmgame2024.GameScreen;
import com.example.rhythmgame2024.R;

public enum GameBeats {

    BEAT(R.drawable.beats),
    BEATTAP(R.drawable.tap_beat_check),
    LINE(R.drawable.line);

    private Bitmap beats;
    private Bitmap tapCheck;
    private Bitmap line;
    private BitmapFactory.Options options = new BitmapFactory.Options();

    GameBeats(int resID) {
        beats = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        beats = getScaledBitmap(beats, 0.6, 0.6);
        tapCheck = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        tapCheck = getScaledBitmap(tapCheck, 0.8,0.8);
        line = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID, options);
        line = getScaledBitmap(line, 0.5,2);

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
