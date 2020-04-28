package modules;

import java.io.*;
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
                switch(arguments[0]) {
                    case "right":
                        destinationX = currentPlayer.getPosition().getPositionX() + 1;
                        destinationY = currentPlayer.getPosition().getPositionY();
                        break;
                    case "down":
                        destinationX = currentPlayer.getPosition().getPositionX();
                        destinationY = currentPlayer.getPosition().getPositionY() + 1;
                        break;
                    case "left":
                        destinationX = currentPlayer.getPosition().getPositionX() - 1;
                        destinationY = currentPlayer.getPosition().getPositionY();
                        break;
                    case "up":
                        destinationX = currentPlayer.getPosition().getPositionX();
                        destinationY = currentPlayer.getPosition().getPositionY() - 1;
                        break;
                    default:
                        throw new IllegalArgumentException("illegal argument to step");
                }
                currentPlayer.step(map.getTileByCoord(destinationX, destinationY));
                break;

            case "player-pass":
                gameController.getCurrentPlayer().pass();
                break;

            // TODO: use argument as item choser instead of interactive user input
            case "use-item":
                Item chosen;
                for (int i = 0; i < currentPlayer.getItems().size(); i++) {
                    currentPlayer.getItems().get(i).toString();
                    System.out.print(" ");
                    if (arguments[0] == currentPlayer.getItems().get(i).toString()) {
                        chosen = currentPlayer.getItems().get(i);
                        currentPlayer.useItem(chosen);
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
                switch(arguments[0]){
                    case "right":
                        destinationX = currentPlayer.getPosition().getPositionX() + 1;
                        destinationY = currentPlayer.getPosition().getPositionY();

                        break;
                    case "down":
                        destinationX = currentPlayer.getPosition().getPositionX();
                        destinationY = currentPlayer.getPosition().getPositionY() + 1;
                        break;
                    case "left":
                        destinationX = currentPlayer.getPosition().getPositionX() - 1;
                        destinationY = currentPlayer.getPosition().getPositionY();
                        break;
                    case "up":
                        destinationX = currentPlayer.getPosition().getPositionX();
                        destinationY = currentPlayer.getPosition().getPositionY() - 1;
                        break;
                    default:
                        throw new IllegalArgumentException("illegal argument to move-bear");
                }
                bear.move(map.getTileByCoord(destinationX, destinationY));
                break;

            case "generate-storm":
                gameController.getMap().generateStorm();
                break;

            case "use-ability":
                if (arguments[0] == null) {
                    currentPlayer.useAbility(gameController.getCurrentPlayer().getPosition());
                }
                else {
                    currentPlayer.useAbility(gameController.getMap().getTile(Integer.parseInt(arguments[0])));
                }
                break;

            default:
                System.out.printf("Unknown command: %s", command);
                return;
        }

    }
}
