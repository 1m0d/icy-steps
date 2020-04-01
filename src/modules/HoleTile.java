package modules;

public class HoleTile extends Tile
{
    public HoleTile(Map map, int parseInt, int parseInt1) {
    }

    public HoleTile(Map map, int Id) {
        this.map = map;
    }


    public void onPlayerStep(Player p)
    {
        Logger.LogFunctionCall(this.toString() + " onPlayerStep was called with param: " + p.toString());
        p.onHole();
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onShovel()
    {
        Logger.LogFunctionCall(this.toString() + "onShovel was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onRope()
    {
        Logger.LogFunctionCall(this.toString() + "onRope was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public Tile getNeighbour(int i)
    {
        Logger.LogFunctionCall(this.toString() + "getNeighbour was called with param: " + i);
        RegularTile rt = new RegularTile(map, 0);
        Logger.LogFunctionReturn("return with " + rt.toString());
        return rt;
    }
}