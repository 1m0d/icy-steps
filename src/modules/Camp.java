package modules;

public class Camp extends Item {

    public Camp(Tile t, Player p) {
        super(t, p);
    }

    @Override
    public void useItem(Tile t) {

    }

    public Camp() {}

    public void useItem(Item i)
    {
        tile.onCamp();
    }
}
