package modules;

public class Shovel extends Item        //shovel item inherits the item class
{
    public Shovel()     //constructor
    {
        super();
    }

    @Override
    public void useItem(Tile t)     //player uses the item
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.onShovel();               //calls the tile's method 
        Logger.LogFunctionReturn("return");
    }
}
