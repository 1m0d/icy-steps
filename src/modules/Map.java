package modules;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *a térkép osztálya
 */
public class Map{
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private int rowCount = 0;
    private int columnCount = 0;
    private Interpreter interpreter = new Interpreter();
    GameController gameController = GameController.getInstance();

    /**
     *sorok, oszlopok getterei, setterei
     */
    public int getRowCount() { return rowCount; }
    public void addRowCount() { rowCount++; }
    public int getColumnCount() { return columnCount; }
    public void setColumnCount(int columnCount) { this.columnCount = columnCount; }

    /**
     *konstruktor
     */
    public Map() { }

    /**
     *a térképen lévő eszközök
     */
    public ArrayList<Item> getItems(){ return items; }

    /**
     *vihar generálása
     */
    public void generateStorm() {
        for (Tile t : chooseStormTiles()) {
            t.onStorm();
        }
    }

    /**
     *mező hozzáadása a térképhez
     */
    public void addTile(Tile newTile) {
        if(getTileById(newTile.getUniqueID()) != null)
            throw new IllegalArgumentException("Unique ID already taken");

        tiles.add(newTile);
    }

    /**
     *eszköz hozzáadása a térképhez
     */
    public void addItem(Item i, int id) {
        items.add(i);
        Player player = GameController.getInstance().getPlayer(id);
        if (player == null) {
            Tile tile = getTileById(id);
            i.tile = tile;
            ((RegularTile)tile).setItem(i);
        }
        else {
            player.addItemToInventory(i);
            i.setPlayer(player);
        }
    }

    /**
     *kiválasztja, hogy mely mezőket érinti a vihar
     */
    private ArrayList<Tile> chooseStormTiles() {
        ArrayList<Tile> stormTiles = new ArrayList<>();
        for (Tile t: tiles)
        {
            for(int i = 0; i<5; i++)
            {
            int id = ThreadLocalRandom.current().nextInt(1, rowCount * columnCount + 1);
            if(t.getUniqueID() == id)
                stormTiles.add(t);
            }
        }
        return stormTiles;
    }

    /**
     *a medve mozog
     */
    public void moveBear()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5);

       String arg[] ={"1"};

        switch(randomNum){
            case 1:
                arg[0]="left";
                break;
            case 2:
                arg[0]="down";
                break;
            case 3:
                arg[0]="right";
                break;
            case 4:
                arg[0]="up";
                break;
        }

        if (!(gameController.getBear().getPosition().getPositionX() == 0 && arg[0] == "left" ||
                gameController.getBear().getPosition().getPositionX() == GameController.getInstance().getMap().getRowCount()-1 && arg[0] == "right" ||
                gameController.getBear().getPosition().getPositionY() == 0 && arg[0] == "up" ||
                gameController.getBear().getPosition().getPositionY() == GameController.getInstance().getMap().getColumnCount()-1 && arg[0] == "down"))
        {  interpreter.executeCommand("move-bear", arg);}


    }

    public ArrayList<Tile> getAllTiles()
    {
        return this.tiles;
    }

    /**
     *koordináták alapján megkap egy mezőt
     */
    public Tile getTileByCoord(int x, int y)
    {
        for (Tile t: this.tiles
             ) {
            if ( t.positionX == x && t.positionY == y)
            {
                return t;
            }
        }
        return null;
    }

    /**
     *id alapján megkap egy mezőt
     */
    public Tile getTileById(int id) {
        if(tiles == null)
            return null;

        for (Tile tile : tiles) {
            if (tile.getUniqueID() == id)
                return tile;
        }
        return null;
    }
}
