package gui.controllers;

import gui.GameView;
import gui.ToolbarView;
import modules.GameController;
import modules.Interpreter;
import modules.Player;
import modules.Scientist;

import javax.swing.*;

public class ToolBarController {
    ToolbarView toolbarView;
    GameView gameView = GameView.getInstance();
    GameController gameController = GameController.getInstance();
    Interpreter interpreter = new Interpreter();

    public ToolBarController(){
        toolbarView = ToolbarView.getInstance();
    }

    // runs on any button press
    public void toolbarButtonPressed(){
        gameView.getMainPanel().repaint();
        toolbarView.getToolbarPanel().repaint();
    }

    public void passButtonPressed(){
        interpreter.executeCommand("player-pass", null);
    }

    public void stepButtonPressed(JComboBox stepDirCB){
        interpreter.executeCommand("step", new String[]{stepDirCB.getSelectedItem().toString()});
    }

    public void clearSnowButtonPressed(){
        interpreter.executeCommand("clear-snow", null);
    }

    public void pickUpItemButtonPressed(){
        interpreter.executeCommand("pick-up-item", null);
    }

    public void useAbilityButtonPressed(JComboBox useAbilityCB){
        Player currentPlayer = gameController.getCurrentPlayer();
        if (currentPlayer instanceof Scientist) {
            interpreter.executeCommand("use-scientist-ability", new String[]{useAbilityCB.getSelectedItem().toString()});
        }
        else {
            interpreter.executeCommand("use-eskimo-ability", null);
        }
    }

    public void foodButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"food"});
    }

    public void campButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"camp"});
    }

    public void divingsuitButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"diving-suit"});
    };

    public void shovelButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"shovel"});
    }

    public void fShovelButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
    };

    public void ropeButtonPressed(){
        // TODO: should be able to choose which square to use it on
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void winItemButtonPressed(){
        interpreter.executeCommand("use-item", new String[]{"winning-item"});
    }

}
