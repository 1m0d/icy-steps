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
        System.out.println( this.toString() + " getPlayer was called");
        onFood();
        return this;
    }


    private void addItemToInventory(Item i)
    {
        System.out.println( this.toString() + " addItemToInventory was called with param: " + i.toString());
       // itemList.Add(i);
    }

    public void work()
    {
        System.out.println( this.toString() + " work was called");
    }

    public void turn()
    {
        System.out.println( this.toString() + " turn was called");
    }

    public void step(Tile t)
    {
        System.out.println( this.toString() + " step was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void pass()
    {
        System.out.println( this.toString() + " pass was called");
        position.map.getGameController().turn();
    }

    public void pickUpItem()
    {
        System.out.println( this.toString() + " pickUpItem was called");
        addItemToInventory(position.item);

    }

    public void useItem(Item i)
    {
        i.useItem(position);
        System.out.println( this.toString() + " useItem was called with param: " + i.toString());
    }

    public void useAbility(Tile t)
    {
        System.out.println( this.toString() + " useAbility was called with param: " + t.toString());
    }

    public void onStorm()
    {
        System.out.println( this.toString() + " onStorm was called");
    }

    public void onFood()
    {
        System.out.println( this.toString() + " onFood was called");
    }

    public void onHole()
    {
        System.out.println( this.toString() + " onHole was called");
    }

    public void getPulledTo(Tile t)
    {
        System.out.println( this.toString() + " getPulledTo was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void clearSnow()
    {
        System.out.println( this.toString() + " clearSnow was called");
    }

    public void setDivingSuit()
    {
        System.out.println( this.toString() + " setDivingSuit was called");
    }

    public int getEnergy()
    {
        return energy;
    }
}