package modules;

public class Rope extends Item      //rope inherits the item class
{
    @Override
    public void useItem(Tile t)     //player uses a rope
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.onRope(t);
        Logger.LogFunctionReturn("return");
    }
}
