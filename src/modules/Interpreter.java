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
                gameController.endPlayerTurn();
                for (Player p : gameController.getAllPlayers() ) {
                    p.energy = 0;
                    p.activePlayer = false;
                }
                gameController.getPlayer(Integer.parseInt(arguments[0])).startTurn();
                break;
            case "step":
                switch(arguments[0]) {
                    case "right":
                        gameController.getCurrentPlayer().step(gameController.getMap().getTileByCoord(
                                gameController.getCurrentPlayer().getPosition().positionX+1,
                                gameController.getCurrentPlayer().getPosition().positionY));

                        break;
                    case "down":
                        gameController.getCurrentPlayer().step(gameController.getMap().getTileByCoord(
                                gameController.getCurrentPlayer().getPosition().positionX,
                                gameController.getCurrentPlayer().getPosition().positionY-1));
                        break;
                    case "left":
                        gameController.getCurrentPlayer().step(gameController.getMap().getTileByCoord(
                                gameController.getCurrentPlayer().getPosition().positionX-1,
                                gameController.getCurrentPlayer().getPosition().positionY));
                        break;
                    case "up":
                        gameController.getCurrentPlayer().step(gameController.getMap().getTileByCoord(
                                gameController.getCurrentPlayer().getPosition().positionX,
                                gameController.getCurrentPlayer().getPosition().positionY+1));
                        break;
                }

            case "player-pass":
                gameController.getCurrentPlayer().pass();
                break;
            case "use-item":
                Item chosen;
                for (int i = 0; i<gameController.getCurrentPlayer().getItems().size(); i++) {
                    gameController.getCurrentPlayer().getItems().get(i).toString();
                    System.out.print(" ");
                    if (arguments[0] == gameController.getCurrentPlayer().getItems().get(i).toString())
                    {
                        chosen = gameController.getCurrentPlayer().getItems().get(i);
                        gameController.getCurrentPlayer().useItem(chosen);
                    }
                }

                break;
            case "pick-up-item":
                gameController.getCurrentPlayer().addItemToInventory(gameController.getCurrentPlayer().getPosition().getItem());
                break;
            case "clear-snow":
                gameController.getCurrentPlayer().clearSnow();
                break;
            case "move-bear":
                switch(arguments[0]){
                    case "right":
                        gameController.getBear().move(gameController.getMap().getTileByCoord
                                (gameController.getBear().getPosition().positionX+1, gameController.getBear().getPosition().positionY ));

                        break;
                    case "down":
                        gameController.getBear().move(gameController.getMap().getTileByCoord
                                (gameController.getBear().getPosition().positionX, gameController.getBear().getPosition().positionY-1 ));
                        break;
                    case "left":
                        gameController.getBear().move(gameController.getMap().getTileByCoord
                                (gameController.getBear().getPosition().positionX-1, gameController.getBear().getPosition().positionY ));
                        break;
                    case "up":
                        gameController.getBear().move(gameController.getMap().getTileByCoord
                                (gameController.getBear().getPosition().positionX, gameController.getBear().getPosition().positionY+1 ));
                        break;
                    case "random":
                        break;
                }

                break;
            case "generate-storm":
                gameController.getMap().generateStorm();
                break;
            case "use-ability":
                if (arguments[0] == null) {
                    gameController.getCurrentPlayer().useAbility(gameController.getCurrentPlayer().getPosition());
                }
                else {
                    gameController.getCurrentPlayer().useAbility(gameController.getMap().getTile(Integer.parseInt(arguments[0])));
                }
                break;
            default:
                System.out.printf("Unknown command: %s", command);
                return;
        }

    }
}
