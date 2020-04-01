package modules;

import java.util.ArrayList;

public abstract class Tile
{
    protected Map map;                      //the map where the tile is
    protected int Id;                       //the id of the tile
    protected int playerCapacity;           //number of players that can be on this tile
    protected int snowLayerCount;           //the amount of snow there is on this tile
    protected boolean scientistChecked;     //the scientist checked the tile or not
    protected boolean iglooBuilt = false;   //if true, theres an igloo on this tile
    protected Item item;                    //the Item on this tile
    protected ArrayList<Player> players = new ArrayList<Player>();  //

    public Tile(Map map, int Id){           //constructor
        this.map = map;
        this.Id = Id;
    }

    public Tile()
    {

    }
    public void setItem(Item newItem){          //setter for the item
        item = newItem;
    }
    public int getId(){                     //getter for the id attribute
        return Id;
    }

    public void setSnowLayerCount(int i)        //it sets the snowlayercount attribute with the i number
    {
        snowLayerCount -= i;                    //because it removes snow it decreases the attribute's value by the i number
	}



    public ArrayList<Player> getPlayers()           //the list of players
    {
        return players;
    }
    public void onPlayerStep(Player p) {            //the player steps to this tile
        Logger.LogFunctionCall(this.toString() + " onPlayerStep was called with param:" + p);
        players.add(p);
      /*  if (players.size() > playerCapacity){
            flip();
        }*/
        Logger.LogFunctionReturn("return");
    }

    public void onPlayerLeave(Player p){            //the player leaves this tile
        Logger.LogFunctionCall(this.toString() + " onPlayerLeave was called" + p);
        players.remove(p);
        Logger.LogFunctionReturn("return");
    }
        
    public void onShovel()          //the shovel item's effect on the tile
    {
        Logger.LogFunctionCall(this.toString() + "onShovel was called");
        Logger.LogFunctionReturn("return");
        setSnowLayerCount(2);           //the shovel removes 2 snow
    }

    public void onRope(Tile t)            //the rope item's effect on the tile
    {
        for(Player p : t.players)           //for each player the getpulled to is called
        {
            getPulledTo(this);
		}
        Logger.LogFunctionCall(this.toString() + "onRope was called");
        Logger.LogFunctionReturn("return");
    }

    public void onStorm()       // the storms effect on the tile
    {
        Logger.LogFunctionCall(this.toString() + "onStorm was called");
        for (Player p : players){       //every player's onstorm method is called, in a for cycle
            p.onStorm();
        }
        Logger.LogFunctionReturn("return");
    }

    public Tile getNeighbour(int i)     //returns the selected tile adjacent to this tile, i is the number of the neighbor tile
                                        //(because its a hexagon map and all tile has 6 adjacent tile)
    {
        Logger.LogFunctionCall(this.toString() + "getNeighbour was called with param: " + i);
        //TODO
        RegularTile rt = new RegularTile(map, 0);
        Logger.LogFunctionReturn("return: " + rt.toString());
        return rt;
    }

    public void onEskimoAbility()       //when eskimo uses ability this method is called on tile
    {
        Logger.LogFunctionCall(this.toString() +  "onEskimoAbility was called");
        Logger.LogFunctionReturn("return");
        this.iglooBuilt = true;        //sets the igloo boolean true on tile
    }

    public int onScientistAbility()     //when scientist uses ability this method is called on tile
    {
        Logger.LogFunctionCall(this.toString() +  "onScientistAbility was called");
        Logger.LogFunctionReturn("return with " + playerCapacity);
        return playerCapacity;          //returns the capacity of the tile
    }

    private void flip()         //the flip method is called when more players in the tile than the palyerCapacity
    {
        Logger.LogFunctionCall(this.toString() +  "flip was called");
        map.getGameController().lose();                     //it calls the lose method of the gamecontroller
        Logger.LogFunctionReturn("return");
    }
}
