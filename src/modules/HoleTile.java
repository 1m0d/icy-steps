package modules;

public class HoleTile extends Tile      //hole tile, inherits from tile class
{
    public HoleTile(Map map, int parseInt, int parseInt1) {
    }

    public HoleTile(Map map, int Id) {
        this.map = map;
    }


    public void onPlayerStep(Player p)
    {
        Logger.LogFunctionCall(this.toString() + " onPlayerStep was called with param: " + p.toString());
       players.add(p);          //add player to the tile's array of players
       p.onHole();              //calls the players method for stucking in hole
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onShovel()      //the shovel item's effect on the tile
    {
        Logger.LogFunctionCall(this.toString() + "onShovel was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onRope()        //the rope item's effect on the tile
    {
        Logger.LogFunctionCall(this.toString() + "onRope was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public Tile getNeighbour(int i) //returns the selected tile adjacent to this tile, i is the number of the neighbor tile
                                    //(because its a hexagon map and all tile has 6 adjacent tile)
    {
        Logger.LogFunctionCall(this.toString() + "getNeighbour was called with param: " + i);
        RegularTile rt = new RegularTile(map, 0);
        Logger.LogFunctionReturn("return with " + rt.toString());
        return rt;
    }
}