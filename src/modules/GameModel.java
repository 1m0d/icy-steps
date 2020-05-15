package modules;

import gui.IDrawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameModel {
    private Map map = new Map();
    private ArrayList<Player> players = new ArrayList<>();
    private Bear bear;
    private static GameModel gameModel;
    private boolean gameOver = false;
    private boolean playersWon = false;
    private Player currentPlayer;
    private int currentPlayerIndex = 0;

    private ArrayList<IDrawable> drawables = new ArrayList<IDrawable>();

    public static GameModel getInstance() {
        if (gameModel == null)
            gameModel = new GameModel();
        return gameModel;
    }
    private int tileRowCount = 0;

    public boolean isGameOver() { return gameOver; }
    public boolean isPlayersWon() { return playersWon; }

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
        for(Player p : players)
        {
            //drawables.add(p);
        }
        drawables.add(map);
        //drawables.add(bear);


    }

    public void startGame() {
        currentPlayer = players.get(0);
        currentPlayer.startTurn();
    }

    public void endPlayerTurn(){
        currentPlayerIndex++;
        if(currentPlayerIndex == players.size())
            endTurn();

        currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.startTurn();
    }

    public void win() {
        gameOver = true;
        playersWon = true;
    }

    public void lose() {
        gameOver = true;
        playersWon = false;
    }

    public void checkWinningConditions() {
        int winningItemCount = 0;
        int lastPositionID = -1;

        for (Player player: players) {
            if(lastPositionID == -1)
                lastPositionID = player.getPosition().getUniqueID();

            if(lastPositionID != player.getPosition().getUniqueID())
                return;

            for (Item item: player.getItems()) {
                if(item.toString().equals("winning-item")) {
                    winningItemCount++;
                }
            }

            if(winningItemCount >= 3)
                win();
        }
    }

    public Player getPlayer(int Id) {
        for (Player player : players)
            if (player.getUniqueID() == Id)
                return player;
        return null;
    }

    public ArrayList<Player> getAllPlayers() {
        return this.players;
    }

    public Player getCurrentPlayer(){ return currentPlayer; }
    public void setCurrentPlayer(Player player){ currentPlayer = player; }

    public Map getMap() { return map; }

    public Bear getBear() {return bear;}

    private void endTurn() {
        map.generateStorm();
        currentPlayerIndex = 0;
    }

    private void clear(){
        map = new Map();
        players.clear();
        bear = null;
        tileRowCount = 0;
        gameOver = false;
        playersWon = false;
        currentPlayerIndex = 0;
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
                position.addPlayer(eskimo);
            }
            else if (Integer.parseInt(tokens[0]) == 1) {
                Scientist scientist = new Scientist(position, energy, lives, drowning, uniqueID);
                this.players.add(scientist);
                position.addPlayer(scientist);
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
            boolean iglooBuilt = Boolean.parseBoolean(tokens[2]);
            boolean campBuilt = Boolean.parseBoolean(tokens[3]);

            if (Integer.parseInt(tokens[0]) == 0) {
                map.addTile(new HoleTile(columnCount, tileRowCount, snowLayerCount, UID));
            } else {
                RegularTile regularTile = new RegularTile(columnCount, tileRowCount, playerCapacity, snowLayerCount, UID);
                if(iglooBuilt)
                    regularTile.buildIgloo();
                else if(campBuilt)
                    regularTile.buildCamp();
                map.addTile(regularTile);
            }
            columnCount++;
        }
    }

    private void parseBear(String[] bear)
    {
        this.bear = new Bear(map.getTile(Integer.parseInt(bear[0])));
    }

    public ArrayList<IDrawable> getDrawables()
    {
        return drawables;
    }
}