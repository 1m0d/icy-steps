package modules;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *ez az osztály értelmezi az inputokat
 */
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

    /**
     *az adott utasításnak megfelelően meghívja a szükséges függvényeket
     */
    public void executeCommand(String command, String[] arguments){
        Player currentPlayer = gameController.getCurrentPlayer();
        Map map = gameController.getMap();
        int positionX;
        int positionY;
        switch (command){
            /**
             *térkép betöltése
             */
            case "load-map":
                try {
                    gameController.loadMap(testDirectory + "/map");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            /**
             *játék kezdete
             */
            case "start-game":
                gameController.startGame();
                break;

            /**
             *aktuális játékos beállítása
             */
            case "set-player-turn":
                if(currentPlayer != null)
                    currentPlayer.setActivePlayer(false);

                Player player = gameController.getPlayer(Integer.parseInt(arguments[0]));
                player.setActivePlayer(true);
                gameController.setCurrentPlayer(player);
                break;

            /**
             *lépés
             */
            case "step":
                positionX = currentPlayer.getPosition().getPositionX();
                positionY = currentPlayer.getPosition().getPositionY();
                if ((positionX == 0 && arguments[0] == "left" ||
                        positionX == GameController.getInstance().getMap().getRowCount()-1 && arguments[0] == "right" ||
                        positionY == 0 && arguments[0] == "up" ||
                         positionY == GameController.getInstance().getMap().getColumnCount()-1 && arguments[0] == "down"))
                {break;
                    }
                else {currentPlayer.step(getTileByDirection(arguments[0], positionX, positionY));}
                break;

            /**
             *a játékos passzolja a körét
             */
            case "player-pass":
                currentPlayer.pass();
                break;

            /**
             *a játékos használja az itemet
             */
            case "use-item":
                ArrayList<Item> items = currentPlayer.getItems();
                for (Item item : items) {
                    if(item.toString().equals(arguments[0])) {
                        if (arguments.length == 2) {
                            currentPlayer.useItem(item, map.getTileById(Integer.parseInt(arguments[1])));
                        } else {
                            currentPlayer.useItem(item);
                        }
                    }
                }
                break;

            /**
             *a játékos felveszi az itemet
             */
            case "pick-up-item":
                currentPlayer.pickUpItem();
                break;

            /**
             *havat tisztít
             */
            case "clear-snow":
                currentPlayer.clearSnow();
                break;

            /**
             *a medve mozog
             */
            case "move-bear":
                Bear bear = gameController.getBear();
                positionX = bear.getPosition().getPositionX();
                positionY = bear.getPosition().getPositionY();

                bear.move(getTileByDirection(arguments[0], positionX, positionY));
                break;

            /**
             *vihar generálódik
             */
            case "generate-storm":
                if(arguments.length == 1)
                    map.getTileById(Integer.parseInt(arguments[0])).onStorm();

                gameController.getMap().generateStorm();
                break;

            /**
             *az eszkimo használja a képességét
             */
            case "use-eskimo-ability":
                currentPlayer.useAbility(gameController.getCurrentPlayer().getPosition());
                break;

            /**
             *a tudós használja a képességét
             */
            case "use-scientist-ability":
                positionX = currentPlayer.getPosition().getPositionX();
                positionY = currentPlayer.getPosition().getPositionY();
                currentPlayer.useAbility(getTileByDirection(arguments[0], positionX, positionY));
                break;

            default:
                System.out.printf("Unknown command: %s", command);
                return;
        }

    }

    /**
     *a kapott irányoknak megfelelően változtatja meg a koordinátákat
     */
    public Tile getTileByDirection(String argument, int positionX, int positionY)
    {
        Map map = gameController.getMap();
        int destinationX;
        int destinationY;
        switch(argument) {
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
                throw new IllegalArgumentException("illegal argument");
        }
        return map.getTileByCoord(destinationX, destinationY);
    }
}
