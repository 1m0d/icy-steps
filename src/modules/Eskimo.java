package modules;

public class Eskimo extends Player
{
    public Eskimo(int Id, Tile position)
    {
        super(position);
    }

    @Override
    public void work()
    {
        Logger.LogFunctionCall(this.toString() + " work was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void turn()
    {
        Logger.LogFunctionCall(this.toString() + " turn was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void pickUpItem()
    {
        Logger.LogFunctionCall(this.toString() + " pickUpItem was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void useAbility(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useAbility was called with param: " + t.toString());
        t.onEskimoAbility();
        Logger.LogFunctionReturn("return");

    }

    @Override
    public void onFood()
    {
        Logger.LogFunctionCall(this.toString() + " onFood was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onHole()
    {
        Logger.LogFunctionCall(this.toString() + " onHole was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void getPulledTo(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " getPulledTo was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }
}
