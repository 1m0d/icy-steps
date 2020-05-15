package main;

import gui.MainFrame;
import modules.*;

import java.io.FileNotFoundException;

public class Main {
    public Map map;
    public static void main(String[] args)  {
        GameModel gameModel = GameModel.getInstance();
        Interpreter interpreter = new Interpreter();
        try {
            gameModel.loadMap("maps/map");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MainFrame myFrame = new MainFrame("icy-steps");
    }
}
