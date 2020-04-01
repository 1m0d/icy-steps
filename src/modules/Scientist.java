package modules;

public class Scientist extends Player       //scientist inherits the player class
{

    public Scientist(int Id, Tile position)     //constructor
    {
        super(position);
    }

    @Override
    public void work()
    {
        Logger.LogFunctionCall(this.toString() + "work was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void turn()              
    {
        Logger.LogFunctionCall(this.toString() + "turn was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void pickUpItem()
    {
        Logger.LogFunctionCall(this.toString() + "pickUpItem was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void useAbility(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useAbility was called with param: " + t.toString());
        t.onScientistAbility();
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onFood()                    //the player eats a food, gets a life
    {
        Logger.LogFunctionCall(this.toString() + "onFood was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onHole()
    {
        Logger.LogFunctionCall(this.toString() + "onHole was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void getPulledTo(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + "getPulledTo was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }
}