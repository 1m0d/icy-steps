package modules;

public class WinningItem extends Item       //winning item inherits the item class
{
    @Override
    public void useItem(Tile t)             //player uses the item
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.map.getGameController().checkWinningConditions();
        Logger.LogFunctionReturn("return");
    }
}
