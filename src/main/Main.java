package main;

import gui.MainFrame;
import modules.*;

import java.io.FileNotFoundException;

public class Main {
    public Map map;
    public static void main(String[] args)  {
        GameController gameController = GameController.getInstance();
        Interpreter interpreter = new Interpreter();
        try {
            gameController.loadMap("maps/map");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MainFrame myFrame = new MainFrame("icy-steps");
    }
}
