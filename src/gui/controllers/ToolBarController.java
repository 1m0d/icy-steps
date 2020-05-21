package gui.controllers;

import gui.GameView;
import gui.ToolbarView;
import modules.*;

import javax.swing.*;
import java.awt.*;

/**
 *a toolbart irányító osztály
 */
public class ToolBarController {
    private ToolbarView toolbarView;
    private GameView gameView = GameView.getInstance();
    private GameController gameController = GameController.getInstance();
    private Interpreter interpreter = new Interpreter();
    private String itemSelected;

    public ToolBarController(){
        toolbarView = ToolbarView.getInstance();
    }

    /**
     *minden gombnyomásra meghívódik
     */
    public void toolbarButtonPressed(JComboBox useAbilityCB, JComboBox ropeCB, JLabel playerStatus){
        if (gameController.getCurrentPlayer() instanceof Eskimo) {
            useAbilityCB.setVisible(false);
        } else{
            useAbilityCB.setVisible(true);
        }

        if(itemSelected != "rope"){
            ropeCB.setVisible(false);
        }
        Boolean btnVisibilities[] = new Boolean[]{false,false,false,false,false,false,false,false,false};
        int iter = 6;
        for(Item i : gameController.getCurrentPlayer().getItems()) {
            System.out.println(i.toString());
            switch (i.toString()) {
                case "camp":
                    btnVisibilities[0] = true;
                    break;
                case "diving-suit":
                    btnVisibilities[1] = true;
                    break;
                case "food":
                    btnVisibilities[2] = true;
                    break;
                case "rope":
                    btnVisibilities[3] = true;
                    break;
                case "shovel":
                    btnVisibilities[4] = true;
                    break;
                case "fragile-shovel":
                    btnVisibilities[5] = true;
                    break;
                case "winning-item":
                    btnVisibilities[iter] = true;
                    iter++;
                    break;
                default:
                    System.out.println(i.toString() + "type could not been found");
            }
        }
        for (int i = 0; i < ToolbarView.getItemButtons().size(); i++)
        {
            if(btnVisibilities[i] == false)
            {
                ToolbarView.getItemButtons().get(i).setVisible(false);
            }
            else
            {
                ToolbarView.getItemButtons().get(i).setVisible(true);

            }
        }

        playerStatus.setText(gameController.getCurrentPlayer().toString());

        gameView.getMainPanel().repaint();
        toolbarView.getToolbarPanel().repaint();
    }

    /**
     *pass button
     */
    public void passButtonPressed(){
        interpreter.executeCommand("player-pass", null);
    }

    /**
     *step button
     */
    public void stepButtonPressed(JComboBox stepDirCB){
        interpreter.executeCommand("step", new String[]{stepDirCB.getSelectedItem().toString()});
    }

    /**
     *clear snow button
     */
    public void clearSnowButtonPressed(){
        interpreter.executeCommand("clear-snow", null);
    }

    /**
     *pick up item button
     */
    public void pickUpItemButtonPressed(){
        interpreter.executeCommand("pick-up-item", null);
    }

    /**
     *use ability button
     */
    public void useAbilityButtonPressed(JComboBox useAbilityCB){
        Player currentPlayer = gameController.getCurrentPlayer();
        if (currentPlayer instanceof Scientist) {
            interpreter.executeCommand("use-scientist-ability", new String[]{useAbilityCB.getSelectedItem().toString()});
        }
        else {
            interpreter.executeCommand("use-eskimo-ability", null);
        }
    }

    /**
     *itemek gombjai
     */
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
