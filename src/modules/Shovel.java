package modules;

public class Shovel extends Item
{
    public Shovel()
    {
        super();
    }

    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.onShovel();
        Logger.LogFunctionReturn("return");
    }
}
