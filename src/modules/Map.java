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
        Logger.LogFunctionCall(this.toString() + "generateStorm was called");
        chooseStormTiles();
        Logger.LogFunctionReturn("return");
    }

    public void addTile(int newTileId, Tile newTile)
    {
        Logger.LogFunctionCall(this.toString() + "addTile was called with param: " + newTile.toString());
        for (Tile tile : tiles)
            if (tile.getId() == newTile.getId())
                return;
        tiles.add(newTile);
        Logger.LogFunctionReturn("return");
    }

    private Tile[] chooseStormTiles ()
    {
        Logger.LogFunctionCall(this.toString() + "chooseStormTiles was called");
        Tile[] tiles1 = {};
        for (Tile t : tiles) {
            t.onStorm();
        }
        Logger.LogFunctionReturn("return with list of tiles.");
        return  tiles1;
    }

    public Tile getTile(int Id)
    {
        Logger.LogFunctionCall(this.toString() + "getTile was called");
        for (Tile tile : tiles)
            if (tile.getId() == Id) {
                Logger.LogFunctionReturn("return with " + tile.toString());
                return tile;
            }
        Logger.LogFunctionReturn("return with NULL");
        return null;
    }

    public GameController getGameController()
    {
        Logger.LogFunctionCall(this.toString() + "getGameController was called");
        Logger.LogFunctionReturn("return with gameController");
        return gameController;
    }
}
