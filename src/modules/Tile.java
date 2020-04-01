package modules;

import java.util.ArrayList;

public abstract class Tile
{
    protected Map map;
    protected int Id;
    protected int playerCapacity;
    protected int snowLayerCount;
    protected boolean scientistChecked;
    protected Item item;
    protected ArrayList<Player> players = new ArrayList<Player>();

    public Tile(Map map, int Id){
        this.map = map;
        this.Id = Id;
    }

    public Tile()
    {

    }
    public void setItem(Item newItem){
        item = newItem;
    }
    public int getId(){
        return Id;
    }



    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    public void onPlayerStep(Player p)
    {
        Logger.LogFunctionCall(this.toString() + "onPlayerStep was called with param:" + p);
        players.add(p);
        Logger.LogFunctionReturn("return");
    }

    public void onPlayerLeave(Player p){
        Logger.LogFunctionCall(this.toString() + "onPlayerLeave was called" + p);
        players.add(p);
        Logger.LogFunctionReturn("return");
    }

    public void onShovel()
    {
        Logger.LogFunctionCall(this.toString() + "onShovel was called");
        Logger.LogFunctionReturn("return");
    }

    public void onRope()
    {
        Logger.LogFunctionCall(this.toString() + "onRope was called");
        Logger.LogFunctionReturn("return");
    }

    public void onStorm()
    {
        Logger.LogFunctionCall(this.toString() + "onStorm was called");
        for (Player p : players){
            p.onStorm();
        }
        Logger.LogFunctionReturn("return");
    }

    public Tile getNeighbour(int i)
    {
        Logger.LogFunctionCall(this.toString() + "getNeighbour was called with param: " + i);
        //TODO
        RegularTile rt = new RegularTile(map, 0);
        Logger.LogFunctionReturn("return: " + rt.toString());
        return rt;
    }

    public void onEskimoAbility()
    {
        Logger.LogFunctionCall(this.toString() +  "onEskimoAbility was called");
        Logger.LogFunctionReturn("return");
    }

    public void onScientistAbility()
    {
        Logger.LogFunctionCall(this.toString() +  "onScientistAbility was called");
        Logger.LogFunctionReturn("return");
    }

    private void flip()
    {
        Logger.LogFunctionCall(this.toString() +  "flip was called");
        map.getGameController().lose();
        Logger.LogFunctionReturn("return");
    }

}
