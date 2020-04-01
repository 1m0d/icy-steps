package modules;

public class DivingSuit extends Item        //the DivingSuit class is inherited from the item class
{
    public DivingSuit()     //constructor
    {
        super();
    }

    @Override
    public void useItem(Tile t)     //divingsuit is used by player
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
        player.setDivingSuit();      //calls the players method to turn on the diving suit
    }
}
