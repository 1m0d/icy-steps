package modules;

public abstract class Item          //item class, all items inherits this
{

    RegularTile tile;       //the tile where the item is
    Player player;          //the player who has the item

    public Item()       //constructor
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
        Logger.LogFunctionReturn("return with " + this.toString());
    }
}