package modules;

public class Rope extends Item
{
    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.onRope();
        Logger.LogFunctionReturn("return");
    }
}
