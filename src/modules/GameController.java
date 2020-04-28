package modules;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.*;

public class GameController {
    private Map map = new Map();
    private ArrayList<Player> players = new ArrayList<>();
    private Bear bear;
    private static GameController gameController;
    public static GameController getInstance() {
        if (gameController == null)
            gameController = new GameController();
        return gameController;
    }
    private int tileRowCount = 0;

    public void loadMap(String path) throws FileNotFoundException {
        clear();
        List<String> mapObjects = Arrays.asList("Tiles", "Players", "Items", "Bear");
        File file = new File(path);
        Scanner mapReader = new Scanner(file);

        String currentObject = null;
        while(mapReader.hasNextLine()) {
            String line = mapReader.nextLine();

            if(mapObjects.contains(line.replace(":",""))){
                currentObject = line.replace(":","");
                continue;
            }

            String[] objects = line.split(";");
            switch (currentObject) {
                case "Tiles":
                    parseTiles(objects);
                    tileRowCount++;
                    break;
                case "Players":
                    parsePlayers(objects);
                    break;
                case "Items":
                    parseItems(objects);
                    break;
                case "Bear":
                    parseBear(objects);
                    break;
            }
        }
        mapReader.close();
    }

    private void parsePlayers(String[] players) {
        for (String player : players ) {
            String[] tokens = player.split(",");
            Tile position = map.getTile(Integer.parseInt(tokens[1]));
            int energy = Integer.parseInt(tokens[2]);
            int lives = Integer.parseInt(tokens[3]);
            boolean drowning = tokens[4] == "true";
            int uniqueID = Integer.parseInt(tokens[5]);
            if(Integer.parseInt(tokens[0]) == 0) {
                Eskimo eskimo = new Eskimo(position, energy, lives, drowning, uniqueID);
                this.players.add(eskimo);
            }
            else if (Integer.parseInt(tokens[0]) == 1) {
                Scientist scientist = new Scientist(position, energy, lives, drowning, uniqueID);
                this.players.add(scientist);
            }
        }
    }

    private void parseItems(String[] items) {
        for (String item : items ) {
            String[] tokens = item.split(",");
            switch(tokens[1]) {
                case "camp":
                    map.addItem(new Camp(), Integer.parseInt(tokens[0]));
                    break;
                case "divingSuit":
                    map.addItem(new DivingSuit(), Integer.parseInt(tokens[0]));
                    break;
                case "food":
                    map.addItem(new Food(), Integer.parseInt(tokens[0]));
                    break;
                case "rope":
                    map.addItem(new Rope(), Integer.parseInt(tokens[0]));
                    break;
                case "shovel":
                    map.addItem(new Shovel(), Integer.parseInt(tokens[0]));
                    break;
                case "fragileShovel":
                    map.addItem(new FragileShovel(), Integer.parseInt(tokens[0]));
                    break;
                case "winningItem":
                    map.addItem(new WinningItem(), Integer.parseInt(tokens[0]));
                    break;
                default:
                    System.out.println(tokens[1] + "type could not been found");
            }
        }
    }

    private void parseTiles(String[] tiles) {
        int columnCount = 0;
        for (String tile: tiles ) {
            String[] tokens = tile.split(",");
            int playerCapacity = Integer.parseInt(tokens[0]);
            int snowLayerCount = Integer.parseInt(tokens[1]);
            int UID = Integer.parseInt(tokens[4]);
            boolean iglooBuilt = tokens[2] == "true";
            boolean campBuilt = tokens[3] == "true";

            if (Integer.parseInt(tokens[0]) == 0) {
                map.addTile(new HoleTile(columnCount, tileRowCount, snowLayerCount, UID));
            } else {
                RegularTile regularTile = new RegularTile(columnCount, tileRowCount, playerCapacity, snowLayerCount, UID);
                map.addTile(regularTile);
                if(iglooBuilt)
                    regularTile.buildIgloo();
                else if(campBuilt)
                    regularTile.buildCamp();
            }
            columnCount++;
        }
    }

    private void parseBear(String[] bear){
        this.bear = new Bear(map.getTile(Integer.parseInt(bear[0])));
    }

    private void startGame() {
        System.out.println( this.toString() + " startGame was called");
        turn();
    }

    private void turn()
    {
        System.out.println( this.toString() + " turn was called");
    }

    public void win()
    {
        System.out.println( this.toString() + " win was called");
    }

    public void lose()
    {
        System.out.println( this.toString() + " lose was called");
    }

    public void checkWinningConditions() {
        System.out.println( this.toString() + " checkWinningConditions was called");
    }

    public Player getPlayer(int Id) {
        for (Player player : players)
            if (player.getUniqueID() == Id)
                return player;
        return null;
    }

    public Map getMap() { return map; }

    private void clear(){
        map = new Map();
        players.clear();
        bear = null;
        tileRowCount = 0;
    }
}