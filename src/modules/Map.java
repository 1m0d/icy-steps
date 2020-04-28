package modules;

import java.util.ArrayList;

public class Map {
    private ArrayList<Tile> tiles = new ArrayList<>();

    public Map() { }

    public void generateStorm() {
        for (Tile t : chooseStormTiles()) {
            t.onStorm();
        }
    }

    public void addTile(Tile newTile) {
        if(getTile(newTile.getUniqueID()) != null)
            throw new IllegalArgumentException("Unique ID already taken");

        tiles.add(newTile);
    }

    public void addItem(Item i, int id) {
        Player player = GameController.getInstance().getPlayer(id);
        if (player == null) {
            Tile tile = getTile(id);
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

    public Tile getTile(int id) {
        if(tiles == null)
            return null;

        for (Tile tile : tiles) {
            if (tile.getUniqueID() == id)
                return tile;
        }
        return null;
    }
}
