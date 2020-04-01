package modules;

import java.util.ArrayList;
import java.util.List;

public abstract class Player
{
    protected int Id;
    protected int energy = 4;
    protected int lives;
    protected List<Item> itemList;
    protected boolean hasDivingSuit;
    protected Tile position;

    public int getId(){
        return Id;
    }

    public Player(Tile position)
    {
        this.position = position;
    }

    public Player getPlayer()
    {
        Logger.LogFunctionCall(this.toString() + " getPlayer was called");
        onFood();
        Logger.LogFunctionReturn("return");
        return this;
    }


    private void addItemToInventory(Item i)
    {
        Logger.LogFunctionCall(this.toString() + " addItemToInventory was called with param: " + i.toString());
        Logger.LogFunctionReturn("return");
       // itemList.Add(i);
    }

    public void work()
    {
        Logger.LogFunctionCall(this.toString() + " work was called");
        Logger.LogFunctionReturn("return");
    }

    public void turn()
    {
        Logger.LogFunctionCall(this.toString() + " turn was called");
        Logger.LogFunctionReturn("return");
    }

    public void step(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " step was called with param: " + t.toString());
        t.onPlayerStep(this);
        if (position != null) {
            position.onPlayerLeave(this);
        }
        Logger.LogFunctionReturn("return");
    }

    public void pass()
    {
        Logger.LogFunctionCall(this.toString() + " pass was called");
        position.map.getGameController().turn();
        Logger.LogFunctionReturn("return");
    }

    public void pickUpItem()
    {
        Logger.LogFunctionCall(this.toString() + " pickUpItem was called");
        addItemToInventory(position.item);
        Logger.LogFunctionReturn("return");

    }

    public void useItem(Item i)
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + i.toString());
        i.useItem(position);
        Logger.LogFunctionReturn("return");
    }

    public void useAbility(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " useAbility was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }

    public void onStorm()
    {
        Logger.LogFunctionCall(this.toString() + " onStorm was called");
        Logger.LogFunctionReturn("return");
    }

    public void onFood()
    {
        Logger.LogFunctionCall(this.toString() + " onFood was called");
        Logger.LogFunctionReturn("return");
    }

    public void onHole()
    {
        Logger.LogFunctionCall(this.toString() + " onHole was called");
        Logger.LogFunctionReturn("return");
    }

    public void getPulledTo(Tile t)
    {
        Logger.LogFunctionCall(this.toString() + " getPulledTo was called with param: " + t.toString());
        t.onPlayerStep(this);
        Logger.LogFunctionReturn("return");
    }

    public void clearSnow()
    {
        Logger.LogFunctionCall(this.toString() + " clearSnow was called");
        Logger.LogFunctionReturn("return");
    }

    public void setDivingSuit()
    {
        Logger.LogFunctionCall(this.toString() + " setDivingSuit was called");
        Logger.LogFunctionReturn("return");
    }

    public int getEnergy()
    {
        return energy;
    }

    public void setEnergy(int i)
    {
        energy = i;
    }
}