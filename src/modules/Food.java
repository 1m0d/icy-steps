package modules;

public class Food extends Item
{
    public Food()
    {
        super();
    }

    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");

    }


}
