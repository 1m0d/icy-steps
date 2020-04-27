package modules;

import java.util.ArrayList;

public class Map {
    private GameController gameController;
    private ArrayList<Tile> tiles;

    public Map() { }

    public void generateStorm() {
        for (Tile t : chooseStormTiles()) {
            t.onStorm();
        }
    }

    public void addTile(Tile newTile) {
        for (Tile tile : tiles)
            if (tile.getUniqueID() == newTile.getUniqueID())
                return;
        tiles.add(newTile);
    }

    public void addItem(Item i, int id) {
        i.player = GameController.getInstance().getPlayer(id);
        if (i.player == null) {
            i.tile = getTile(id);
            ((RegularTile)getTile(id)).setItem(i);
        }
        else {
            i.tile = null;
        }
    }

    private Tile[] chooseStormTiles() {
        Tile[] tiles = {};
        return tiles;
    }

    public Tile getTile(int id) {
        for (Tile tile : tiles) {
            if (tile.getUniqueID() == id)
                return tile;
        }
        return null;
    }

    public GameController getGameController() {
        return gameController;
    }
}
