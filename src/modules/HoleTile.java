package modules;

public class HoleTile extends Tile
{
    public HoleTile(Map map, int parseInt, int parseInt1) {
    }

    public HoleTile(Map map, int Id) {
        this.map = map;
    }


    public void onPlayerStep(Player p)
    {
        System.out.println( this.toString() + "onPlayerStep was called with param: " + p.toString());
        p.onHole();
    }

    @Override
    public void onShovel()
    {
        System.out.println( this.toString() + "onShovel was called");
    }

    @Override
    public void onRope()
    {
        System.out.println( this.toString() + "onRope was called");
    }

    @Override
    public void onStorm()
    {
        System.out.println( this.toString() + "onStorm was called");
    }

    @Override
    public Tile getNeighbour(int i)
    {
        System.out.println( this.toString() + "getNeighbour was called with param: " + i);
        RegularTile rt = new RegularTile(map, 0);
        return rt;
    }

    @Override
    public void onEskimoAbility()
    {
        System.out.println( this.toString() + "onEskimoAbility was called");
    }

    @Override
    public void onScientistAbility()
    {
        System.out.println( this.toString() + "onScientistAbility was called");
    }

    @Override
    public void flip()
    {
        System.out.println( this.toString() + "flip was called");
    }
}