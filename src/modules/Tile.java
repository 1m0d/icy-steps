package modules;

import java.util.ArrayList;

public abstract class Tile
{
    private ArrayList<Tile> neighbourTiles;

    private int uniqueID;
    private int playerCapacity;
    private boolean scientistChecked;
    private int snowLayerCount;

    private Item item;
    private Player[] players;

    public Tile(int playerCapacity, int snowLayerCount, int uniqueID)
    {
        this.playerCapacity = playerCapacity;
        this.snowLayerCount = snowLayerCount;
        this.uniqueID = uniqueID;
    }

    public abstract void onRope();
    public abstract void onPlayerStep(Player p);
    public abstract  void onTurn();

    public void setItem(Item newItem){
        item = newItem;
    }
    public int getUniqueID(){
        return uniqueID;
    }
    public Player[] getPlayers()
    {
        return players;
    }

    public void onShovel()
    {
        System.out.println( this.toString() + "onShovel was called");
    }
    public void onStorm()
    {
        System.out.println( this.toString() + "onStorm was called");
    }
    public void onCamp()
    {
        System.out.println( this.toString() + "onCamp was called");
    }


    public Tile getNeighbour(int i)
    {
        System.out.println( this.toString() + "getNeighbour was called with param: " + i);
        if (i >= 0 && i < neighbourTiles.size()) {
            Tile ret = neighbourTiles.get(i);
            if (ret != null) {
                return ret;
            }
            else {
                System.out.println("couldnt find neighbourtile in " + i + " direction!");
                return null;
            }
        }
        return null;
    }

    public void onEskimoAbility()
    {
        System.out.println( this.toString() + "onEskimoAbility was called");
    }

    public void onScientistAbility()
    {
        System.out.println( this.toString() + "onScientistAbility was called");
    }

    public void flip()
    {
        System.out.println( this.toString() + "flip was called");
    }

}
