package modules;

public class RegularTile extends Tile
{
    public RegularTile(Map map, int Id) {
        this.map = map;
        this.Id = Id;
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

    @Override
    public void onEskimoAbility()
    {
        Logger.LogFunctionCall(this.toString() + "onEskimoAbility was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onScientistAbility()
    {
        Logger.LogFunctionCall(this.toString() + "onScientistAbility was called");
        Logger.LogFunctionReturn("return");
    }
}