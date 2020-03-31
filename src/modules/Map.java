package modules;

import java.util.ArrayList;

public class Map
{
    private GameController gameController;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    public Map(GameController gc)
    {
        gameController = gc;
    }

    public void generateStorm()
    {
        System.out.println( this.toString() + " generateStorm was called");
        chooseStormTiles();
    }

    public void addTile(int newTileId, Tile newTile)
    {
        System.out.println( this.toString() + "addTile was called with param: " + newTile.toString());
        for (Tile tile : tiles)
            if (tile.getId() == newTile.getId())
                return;
        tiles.add(newTile);
    }

    private Tile[] chooseStormTiles ()
    {
        System.out.println( this.toString() + " chooseStormTiles was called");
        Tile[] tiles1 = {};
        for (Tile t : tiles) {
            t.onStorm();
        }
        return  tiles1;
    }

    public Tile getTile(int Id)
    {
        System.out.println( this.toString() + "getTile was called");
        for (Tile tile : tiles)
            if (tile.getId() == Id)
                return tile;
        return null;
    }

    public GameController getGameController()
    {
        System.out.println( this.toString() + "getGameController was called");
        return gameController;
    }
}
