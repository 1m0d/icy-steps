package modules;

public abstract class Item
{

    RegularTile tile;
    Player player;

    public Item()
    {

    }

    public Item getItem()
    {
        Logger.LogFunctionCall(this.toString() + " getItem was called");
        Logger.LogFunctionReturn("return with " + this.toString());
        return this;
    }
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + "useItem was called with param: " + t.toString());
        player.setDivingSuit();
        Logger.LogFunctionReturn("return with " + this.toString());
    }
}