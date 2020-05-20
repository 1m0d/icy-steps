package gui.controllers;

import gui.GameView;
import gui.ToolbarView;
import modules.GameController;

import javax.swing.*;

public class ToolBarController {
    ToolbarView toolbarView;
    GameView gameView = GameView.getInstance();
    GameController gameController = GameController.getInstance();

    public ToolBarController(){
        toolbarView = ToolbarView.getInstance();
    }

    // runs on any button press
    public void toolbarButtonPressed(){
        gameView.getMainPanel().repaint();
        toolbarView.getToolbarPanel().repaint();
    }
}
