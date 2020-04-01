package modules;

public class Food extends Item      //the Food class is inherited from the item class
{
    public Food()       //constructor
    {
        super();
    }

    @Override
    public void useItem(Tile t)     //food is used by player
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
        player.onFood();            //calls the player's onFood method

    }


}
