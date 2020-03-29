package modules;

public class Shovel extends Item
{
    public Shovel()
    {
        super();
    }

    @Override
    public void useItem(Tile t)
    {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
        t.onShovel();
    }
}
