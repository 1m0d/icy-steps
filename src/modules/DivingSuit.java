package modules;

public class DivingSuit extends Item
{
    public DivingSuit()
    {
        super();
    }

    /**
     * Uses the item.
     *
     * @param t Target tile.
     */
    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }
}
