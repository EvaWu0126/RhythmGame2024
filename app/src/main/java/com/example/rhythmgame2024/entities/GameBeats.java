package com.example.rhythmgame2024.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.rhythmgame2024.GameScreen;
import com.example.rhythmgame2024.R;

public enum GameBeats {

    BEAT(R.drawable.beats);

    private Bitmap beats;

    GameBeats(int resID) {
        beats = BitmapFactory.decodeResource(GameScreen.Companion.getGameContext().getResources(), resID);
    }

    public Bitmap getBeats(){
        return beats;
    }
}
