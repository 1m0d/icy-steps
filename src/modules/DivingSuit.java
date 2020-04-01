package modules;

public class DivingSuit extends Item
{
    public DivingSuit()
    {
        super();
    }

    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        player.setDivingSuit();
        Logger.LogFunctionReturn("return");
    }
}
