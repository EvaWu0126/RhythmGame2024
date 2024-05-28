package com.example.rhythmgame2024;

import android.util.Log;

public class GameLoop  implements Runnable{

    private Thread gameThread;
    private GamePanel gamePanel;

    public boolean isRunning = true;

    public GameLoop(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }

    @Override
    public void run(){

        while(isRunning){
            gamePanel.update(1F);
            gamePanel.render(0F);
            //gamePanel.beatListUpdate();
        }
    }

    public void startGameLoop(){
        if(!gameThread.isAlive()) {
            gameThread.start();
        }
    }

    public void endGameLoop(){
        isRunning = false;
        System.out.println("game ends");
    }

}
