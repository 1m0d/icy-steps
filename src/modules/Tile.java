package modules;

public abstract class Tile
{
    protected Map map;
    protected int Id;
    protected int playerCapacity;
    protected int snowLayerCount;
    protected boolean scientistChecked;
    protected Item item;
    protected Player[] players;

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



    public Player[] getPlayers()
    {
        return players;
    }
    public void onPlayerStep(Player p)
    {
        System.out.println( this.toString() + "onPlayerStep was called with param:" + p);
    }

    public void onShovel()
    {
        System.out.println( this.toString() + "onShovel was called");
    }

    public void onRope()
    {
        System.out.println( this.toString() + "onRope was called");
    }

    public void onStorm()
    {
        System.out.println( this.toString() + "onStorm was called");
    }

    public Tile getNeighbour(int i)
    {
        System.out.println( this.toString() + "getNeighbour was called with param: " + i);
        //TODO
        RegularTile rt = new RegularTile(map, 0);
        return rt;
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
