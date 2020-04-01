package modules;

public class Eskimo extends Player      //eskimo class inherits the player class
{
    public Eskimo(int Id, Tile position)        //constructor
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
    public void turn()      //turn is called
    {
        Logger.LogFunctionCall(this.toString() + " turn was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void pickUpItem()        //eskimo picks up an item
    {
        Logger.LogFunctionCall(this.toString() + " pickUpItem was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void useAbility(Tile t)      //eskimo uses ability
    {
        Logger.LogFunctionCall(this.toString() + " useAbility was called with param: " + t.toString());
        t.onEskimoAbility();            //the tile's method is called, it builds an igloo
        Logger.LogFunctionReturn("return");

    }

    @Override
    public void onFood()                    //the player eats a food, gets a life
    {
        Logger.LogFunctionCall(this.toString() + " onFood was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void onHole()       //when an eskimo steps to a hole tile this method is called
    {
        Logger.LogFunctionCall(this.toString() + " onHole was called");
        Logger.LogFunctionReturn("return");
    }

    @Override
    public void getPulledTo(Tile t)     //the eskimo is saved by another player, goes to the tile where he's saved from
    {
        Logger.LogFunctionCall(this.toString() + " getPulledTo was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }
}
