package modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Interpreter {
    private String testDirectory;
    GameController gameController = GameController.getInstance();

    public void setTestDirectory(String testDirectory){ this.testDirectory = testDirectory; }

    public void execute() throws FileNotFoundException {
        File inputFile = new File(testDirectory + "/input");
        Scanner inputReader = new Scanner(inputFile);

        while(inputReader.hasNextLine()){
            String input = inputReader.nextLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String[] arguments = Arrays.copyOfRange(tokens,1,tokens.length);

            executeCommand(command, arguments);
        }
    }

    public void check() {

    }

    private void executeCommand(String command, String[] arguments) throws FileNotFoundException {
        switch (command){
            case "load-map":
                gameController.loadMap(testDirectory + "/map");
                break;
            case "start-game":
                gameController.startGame();
                break;
            case "set-player-turn":
                break;
            case "step":
                break;
            case "player-pass":
                gameController.getCurrentPlayer().pass();
                break;
            case "use-item":
                break;
            case "pick-up-item":
                break;
            case "clear-snow":
                break;
            case "move-bear":
                break;
            case "generate-storm":
                break;
            case "use-ability":
                break;
            default:
                System.out.printf("Unknown command: %s", command);
                return;
        }

    }
}
