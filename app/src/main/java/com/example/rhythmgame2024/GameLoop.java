package com.example.rhythmgame2024;

public class GameLoop  implements Runnable{

    private Thread gameThread;
    private GamePanel gamePanel;

    public GameLoop(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }

    @Override
    public void run(){

        while(true){
            gamePanel.update(100F);
            gamePanel.render(0F);
        }
    }

    public void startGameLoop(){
        if(!gameThread.isAlive()) {
            gameThread.start();
        }
    }

}
