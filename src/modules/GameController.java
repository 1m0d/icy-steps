package modules;

import gui.GameView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *a játék vezérléésért felelős osztály
 */
public class GameController {
    private Map map;
    private ArrayList<Player> players = new ArrayList<>();
    private Bear bear;
    private static GameController gameController;
    private boolean gameOver = false;
    private boolean playersWon = false;
    private Player currentPlayer;
    private int currentPlayerIndex = 0;

    public static GameController getInstance() {
        if (gameController == null)
            gameController = new GameController();
        return gameController;
    }

    /**
     *vége a játéknak
     */
    public boolean isGameOver() { return gameOver; }

    /**
     *a játékosok nyertek
     */
    public boolean isPlayersWon() { return playersWon; }


    /**
     *betölti a kiválasztott térképet
     */
    public void loadMap(String path) throws FileNotFoundException {
        //map = new Map();
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
                    map.addRowCount();
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

    /**
     *elkezdi a játékot, megkezdődik az első játékos köre
     */
    public void startGame() {
        currentPlayer = players.get(0);
        currentPlayer.startTurn();
    }

    /**
     *befejeződik az adott játékos köre, a következő játékos következik
     */
    public void endPlayerTurn(){
        currentPlayerIndex++;
        if(currentPlayerIndex == players.size())
            endTurn();

        currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.startTurn();
    }

    /**
     *vége a játéknak, a játékosok nyertek
     */
    public void win() {
        gameOver = true;
        playersWon = true;
        GameView.getInstance().gameOver();
    }

    /**
     *vége a játéknak, a játékosok vesztettek
     */
    public void lose() {
        gameOver = true;
        playersWon = false;
        GameView.getInstance().gameOver();
    }

    /**
     *ellenőrzi, hogy teljesülnek-e a nyeréshez szükséges feltételek
     */
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

    /**
     *visszatér az adott id-jú játékossal
     */
    public Player getPlayer(int Id) {
        for (Player player : players)
            if (player.getUniqueID() == Id)
                return player;
        return null;
    }

    /**
     *visszatér az összes játékossal
     */
    public ArrayList<Player> getAllPlayers() {
        return this.players;
    }


    /**
     *visszatér az aktuális játékossal
     */
    public Player getCurrentPlayer(){ return currentPlayer; }

    /**
     *beállítja az aktuális játékost
     */
    public void setCurrentPlayer(Player player){ currentPlayer = player; }

    /**
     *megkapja a térképet
     */
    public Map getMap() { return map; }

    /**
     *megkapja a medvét
     */
    public Bear getBear() {return bear;}

    /**
     *befejeződik egy kör, vihar generálódik és a medve lép
     */
    private void endTurn() {
        map.generateStorm();
        currentPlayerIndex = 0;
        map.moveBear();
    }

    /**
     *törlünk mindent
     */
    private void clear(){
        map = new Map();
        players.clear();
        bear = null;
        gameOver = false;
        playersWon = false;
        currentPlayerIndex = 0;
    }

    /**
     *a játékosok parse-olása
     */
    private void parsePlayers(String[] players) {
        for (String player : players ) {
            String[] tokens = player.split(",");
            Tile position = map.getTileById(Integer.parseInt(tokens[1]));
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

    /**
     *az itemek parse-olása
     */
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
                    System.out.println(tokens[1] + " type could not been found");
            }
        }
    }

    /**
     *a mezők parse-olása
     */
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
                map.addTile(new HoleTile(columnCount, map.getRowCount(), snowLayerCount, UID));
            } else {
                RegularTile regularTile = new RegularTile(columnCount, map.getRowCount(), playerCapacity, snowLayerCount, UID);
                if(iglooBuilt)
                    regularTile.buildIgloo();
                else if(campBuilt)
                    regularTile.buildCamp();
                map.addTile(regularTile);
            }
            columnCount++;
        }
        if(map.getRowCount() == 0){
            map.setColumnCount(columnCount);
        }
    }

    /**
     *a medve parse-olása
     */
    private void parseBear(String[] bear)
    {
        this.bear = new Bear(map.getTileById(Integer.parseInt(bear[0])));
    }

}