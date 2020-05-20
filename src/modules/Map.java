package modules;

import gui.IDrawable;

import javax.swing.*;
import java.util.ArrayList;

public class Map implements IDrawable {
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private int rowCount = 0;
    private int columnCount = 0;

    public int getRowCount() { return rowCount; }
    public void addRowCount() { rowCount++; }
    public int getColumnCount() { return columnCount; }
    public void setColumnCount(int columnCount) { this.columnCount = columnCount; }

    public Map() { }

    public ArrayList<Item> getItems(){ return items; }

    public void generateStorm() {
        for (Tile t : chooseStormTiles()) {
            t.onStorm();
        }
    }

    public void addTile(Tile newTile) {
        if(getTileById(newTile.getUniqueID()) != null)
            throw new IllegalArgumentException("Unique ID already taken");

        tiles.add(newTile);
    }

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

    private Tile[] chooseStormTiles() {
        Tile[] tiles = {};
        return tiles;
    }

    public ArrayList<Tile> getAllTiles()
    {
        return this.tiles;
    }

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
    public Tile getTileById(int id) {
        if(tiles == null)
            return null;

        for (Tile tile : tiles) {
            if (tile.getUniqueID() == id)
                return tile;
        }
        return null;
    }

    @Override
    public void Draw(JPanel jp) {
        for(Tile t: tiles) {
            t.Draw(jp);
        }
    }
}
