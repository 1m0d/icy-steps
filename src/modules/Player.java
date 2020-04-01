package modules;

import java.util.ArrayList;
import java.util.List;

public abstract class Player        //player class is abstract, the eskimo and scientist class inherits it
{
    protected int Id;                       //every palyer has an Id    
    protected int energy = 4;               //energy shows how many steps or ability/item uses can a player do
    protected int lives;                    //the lives of the player
    protected List<Item> itemList;          //the items the player have
    protected boolean hasDivingSuit;        //it shows if the player has a divingsuit on
    protected Tile position;                //the position is the Tile the player is on
        
    public int getId(){                 //getter for the id attribute
        return Id;
    }

    public Player(Tile position)        //constructor
    {
        this.position = position;
    }

    public Player getPlayer()           
    {
        Logger.LogFunctionCall(this.toString() + " getPlayer was called");
        Logger.LogFunctionReturn("return");
        return this;
    }


    private void addItemToInventory(Item i)     //puts the item to the players inventory
    {
        Logger.LogFunctionCall(this.toString() + " addItemToInventory was called with param: " + i.toString());
        Logger.LogFunctionReturn("return");
        itemList.Add(i);
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

    public void step(Tile t)            //the player steps to the t tile
    {
        Logger.LogFunctionCall(this.toString() + " step was called with param: " + t.toString());
        t.onPlayerStep(this);           //player steps to the tile
        if (position != null) {
            position.onPlayerLeave(this);   //we take out the player from the previous tile
        }
        Logger.LogFunctionReturn("return");
    }

    public void pass()                  //pass method ends the turn of the player
    {
        Logger.LogFunctionCall(this.toString() + " pass was called");
        energy = 0;                     //sets the energy to 0, thus the turn ends
        Logger.LogFunctionReturn("return");
    }

    public void pickUpItem()            //player picks up an item for 1 energy
    {
        Logger.LogFunctionCall(this.toString() + " pickUpItem was called");
        addItemToInventory(position.item);      //calls the item adding method
        Logger.LogFunctionReturn("return");

    }

    public void useItem(Item i)             //player uses an item for 1 energy
    {
        Logger.LogFunctionCall(this.toString() + " useItem was called with param: " + i.toString());
        i.useItem(position);
        Logger.LogFunctionReturn("return");
    }

    public void useAbility(Tile t)          //player uses an ability for 1 energy
    {
        Logger.LogFunctionCall(this.toString() + " useAbility was called with param: " + t.toString());
        Logger.LogFunctionReturn("return");
    }

    public void onStorm()                   //the player is in a storm, loses 1 life
    {
        Logger.LogFunctionCall(this.toString() + " onStorm was called");
        Logger.LogFunctionReturn("return");
        lives--;            
    }
        
    public void onFood()                    //the player eats a food, gets a life
    {
        Logger.LogFunctionCall(this.toString() + " onFood was called");
        Logger.LogFunctionReturn("return");
        lives++;
    }

    public void onHole()                //the player 
    {
        Logger.LogFunctionCall(this.toString() + " onHole was called");
        Logger.LogFunctionReturn("return");
    }

    public void getPulledTo(Tile t)     //player goes to the t tile
    {
        Logger.LogFunctionCall(this.toString() + " getPulledTo was called with param: " + t.toString());
        t.onPlayerStep(this);                   //player is added to t tile
        position.onPlayerLeave(this);          //player is removed from its current tile
        Logger.LogFunctionReturn("return");
    }

    public void clearSnow()             //clears 1 unit of snow from tile
    {
        Logger.LogFunctionCall(this.toString() + " clearSnow was called");
        Logger.LogFunctionReturn("return");
        position.setSnowLayerCount(1);      //removes 1 snow
    }

    public void setDivingSuit()         //sets the hasdivingsuit boolean true
    {
        Logger.LogFunctionCall(this.toString() + " setDivingSuit was called");
        Logger.LogFunctionReturn("return");
        hasDivingSuit = true;
    }

    public int getEnergy()      //getter for the energy attribute
    {
        return energy;
    }

    public void setEnergy(int i)        //setter for the energy attribute
    {
        energy = i;
    }
}