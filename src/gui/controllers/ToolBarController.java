package gui.controllers;

import gui.GameView;
import gui.ToolbarView;
import modules.*;

import javax.swing.*;

public class ToolBarController {
    private ToolbarView toolbarView;
    private GameView gameView = GameView.getInstance();
    private GameController gameController = GameController.getInstance();
    private Interpreter interpreter = new Interpreter();
    private String itemSelected;

    public ToolBarController(){
        toolbarView = ToolbarView.getInstance();
    }

    // runs on any button press
    public void toolbarButtonPressed(JComboBox useAbilityCB, JComboBox ropeCB){
        if (gameController.getCurrentPlayer() instanceof Eskimo) {
            useAbilityCB.setVisible(false);
        } else{
            useAbilityCB.setVisible(true);
        }

        if(itemSelected != "rope"){
            ropeCB.setVisible(false);
        }

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

    // item buttons

    public void foodButtonPressed(){
        itemSelected = "food";
        interpreter.executeCommand("use-item", new String[]{"food"});
    }

    public void campButtonPressed(){
        itemSelected = "camp";
        interpreter.executeCommand("use-item", new String[]{"camp"});
    }

    public void divingsuitButtonPressed(){
        itemSelected = "diving-suit";
        interpreter.executeCommand("use-item", new String[]{"diving-suit"});
    };

    public void shovelButtonPressed(){
        itemSelected = "shovel";
        interpreter.executeCommand("use-item", new String[]{"shovel"});
    }

    public void fShovelButtonPressed(){
        itemSelected = "fragile-shovel";
        interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
    };

    public void ropeButtonPressed(JComboBox ropeCB){
        itemSelected = "rope";
        ropeCB.setVisible(true);
    }

    public void winItemButtonPressed(){
        itemSelected = "winning-item";
        interpreter.executeCommand("use-item", new String[]{"winning-item"});
    }

    public void useItemButtonPressed(JComboBox ropeCB){
        if(itemSelected == null)
            return;

        if(itemSelected.equals("rope")) {
            interpreter.executeCommand("use-item", new String[]{itemSelected, ropeCB.getSelectedItem().toString()});
            ropeCB.setVisible(false);
        }
        else {
            interpreter.executeCommand("use-item", new String[]{itemSelected});
        }
    }

}
