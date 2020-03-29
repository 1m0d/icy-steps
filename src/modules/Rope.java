package modules;

public class Rope extends Item
{
    @Override
    public void useItem(Tile t)
    {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
        t.onRope();
    }
}
