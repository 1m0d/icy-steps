package modules;

import java.util.ArrayList;
import java.lang.Math;

public class Map {
    private GameController gameController;
    private ArrayList<Tile> tiles;

    public Map() {
    }

   /* public void generateStorm() {
        System.out.println( this.toString() + " generateStorm was called");
        for (Tile t : chooseStormTiles()) {
            t.onStorm();
        }
    }

    private Tile[] chooseStormTiles() {
        System.out.println( this.toString() + " chooseStormTiles was called");
        Tile[] tiles = {};
        return tiles;
        } */

    public void generateStorm() {
        System.out.println( this.toString() + " generateStorm was called");
        for (int i=0; i<tiles.size(); i++) {
            double rand = Math.random();
            if (rand > 0.5) tiles.get(i).onStorm();
        }
    }

    public void turn() {
        for(Tile t : tiles) {
            t.turn();
        }
    }

    public void addTile(Tile newTile) {
        System.out.println( this.toString() + "addTile was called with param: " + newTile.toString());
        for (Tile tile : tiles)
            if (tile.getUniqueID() == newTile.getUniqueID())
                return;
        tiles.add(newTile);
    }

    public void addItem(Item i, int id) {
        i.player = GameController.getInstance().getPlayer(id);
        if (i.player == null) {
            i.tile = getTile(id);
            getTile(id).setItem(i);
        }
        else {
            i.tile = null;
        }
    }

    public Tile getTile(int id) {
        System.out.println( this.toString() + "getTile was called");
        for (Tile tile : tiles) {
            if (tile.getUniqueID() == id)
                return tile;
        }
        return null;
    }

    public GameController getGameController() {
        System.out.println( this.toString() + "getGameController was called");
        return gameController;
    }
}
