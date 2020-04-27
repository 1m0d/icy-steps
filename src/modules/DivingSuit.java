package modules;

public class DivingSuit extends Item
{

    public DivingSuit(Tile t, Player p) {
        super(t, p);
    }
    public DivingSuit() {}

    @Override
    public void useItem(Tile t)
    {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
    }

    public void getPickedBy(Player p)
    {
    }
}
