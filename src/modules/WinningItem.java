package modules;

public class WinningItem extends Item
{
    @Override
    public void useItem(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        t.map.getGameController().checkWinningConditions();
        Logger.LogFunctionReturn("return");
    }
}
