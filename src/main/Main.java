package main;

import modules.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public Map map;
    public static void main(String[] args)
    {
        GameController gameController = GameController.getInstance();
        Interpreter interpreter = new Interpreter();
        String[] testCasePaths = {
                "00-load-map","01-player-steps-onto-regular-tile","02-player-steps-onto-hole-tile","03-player-uses-eskimo-ability","04-player-uses-scientist-ability",
                "05-player-passes","06-player-picks-up-an-item","07-player-clears-snow","08-player-uses-diving-suit","09-player-uses-food","10-player-uses-winning-item","11-player-uses-rope",
                "12-player-uses-shovel","13-player-uses-fragile-shovel","14-player-uses-fragile-shovel-and-it-breaks","15-player-uses-camp","16-gamecontroller-generates-storm","17-bear-steps",
                "18-bear-meets-player"
        };

        for (int i = 0; i < testCasePaths.length; i++) {
            System.out.println(i + ":\t" + testCasePaths[i]);
        }

        System.out.println("Choose a testcase!");
        Scanner in = new Scanner(System.in);

        int input;
        while (true) {
            input = in.nextInt();
            System.out.printf("Running: %s\n", testCasePaths[input]);
            Path testDirectory = Paths.get("integration_tests/", testCasePaths[input]);
            try {
                gameController.loadMap(testDirectory.toString() + "/map");
                interpreter.execute(testDirectory.toString() + "/input");
                interpreter.check(testDirectory.toString() + "/expected_output");
            } catch (FileNotFoundException e) {
                System.out.printf("File not found: %s\n", e.getMessage());
            }
        }
    }

}
