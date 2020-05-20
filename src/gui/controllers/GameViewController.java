package gui.controllers;

import gui.GameView;

public class GameViewController {
    private static GameView gameView;

    public GameViewController(){
        gameView = GameView.getInstance();
    }
}
