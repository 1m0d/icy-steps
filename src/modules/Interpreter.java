package modules;

import java.io.*;
import java.util.ArrayList;
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

    public void check() throws IOException {
        System.out.println("\nExpected Output:");
        BufferedReader in = new BufferedReader(new FileReader(testDirectory + "/expected-output"));
        String line = in.readLine();
        while(line != null) {
          System.out.println(line);
          line = in.readLine();
        }
        in.close();
    }

    private void executeCommand(String command, String[] arguments) throws FileNotFoundException {
        Player currentPlayer = gameController.getCurrentPlayer();
        Map map = gameController.getMap();
        int positionX;
        int positionY;
        int destinationX;
        int destinationY;
        switch (command){
            case "load-map":
                gameController.loadMap(testDirectory + "/map");
                break;

            case "start-game":
                gameController.startGame();
                break;

            case "set-player-turn":
                if(currentPlayer != null)
                    currentPlayer.setActivePlayer(false);

                Player player = gameController.getPlayer(Integer.parseInt(arguments[0]));
                player.setActivePlayer(true);
                gameController.setCurrentPlayer(player);
                break;

            case "step":
                positionX = currentPlayer.getPosition().getPositionX();
                positionY = currentPlayer.getPosition().getPositionY();
                switch(arguments[0]) {
                    case "right":
                        destinationX = positionX + 1;
                        destinationY = positionY;
                        break;
                    case "down":
                        destinationX = positionX;
                        destinationY = positionY + 1;
                        break;
                    case "left":
                        destinationX = positionX - 1;
                        destinationY = positionY;
                        break;
                    case "up":
                        destinationX = positionX;
                        destinationY = positionY- 1;
                        break;
                    default:
                        throw new IllegalArgumentException("illegal argument to step");
                }
                currentPlayer.step(map.getTileByCoord(destinationX, destinationY));
                break;

            case "player-pass":
                currentPlayer.pass();
                break;

            case "use-item":
                ArrayList<Item> items = currentPlayer.getItems();
                for (Item item : items) {
                    if(item.toString().equals(arguments[0])) {
                        if (arguments.length == 2) {
                            currentPlayer.useItem(item, map.getTile(Integer.parseInt(arguments[1])));
                        } else {
                            currentPlayer.useItem(item);
                        }
                    }
                }
                break;

            case "pick-up-item":
                currentPlayer.pickUpItem();
                break;

            case "clear-snow":
                currentPlayer.clearSnow();
                break;

            case "move-bear":
                Bear bear = gameController.getBear();
                positionX = bear.getPosition().getPositionX();
                positionY = bear.getPosition().getPositionY();
                switch(arguments[0]){
                    case "right":
                        destinationX = positionX + 1;
                        destinationY = positionY;
                        break;
                    case "down":
                        destinationX = positionX;
                        destinationY = positionY + 1;
                        break;
                    case "left":
                        destinationX = positionX - 1;
                        destinationY = positionY;
                        break;
                    case "up":
                        destinationX = positionX;
                        destinationY = positionY- 1;
                        break;
                    default:
                        throw new IllegalArgumentException("illegal argument to move-bear");
                }
                bear.move(map.getTileByCoord(destinationX, destinationY));
                break;

            case "generate-storm":
                if(arguments.length == 1)
                    map.getTile(Integer.parseInt(arguments[0])).onStorm();

                gameController.getMap().generateStorm();
                break;

            case "use-eskimo-ability":
                currentPlayer.useAbility(gameController.getCurrentPlayer().getPosition());
                break;

            case "use-scientist-ability":
                currentPlayer.useAbility(gameController.getMap().getTile(Integer.parseInt(arguments[0])));
                break;

            default:
                System.out.printf("Unknown command: %s", command);
                return;
        }

    }
}
