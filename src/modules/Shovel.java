package modules;

public class Shovel extends Item
{
    public Shovel(Tile t, Player p) {
        super(t, p);
    }
    public Shovel() {}

    @Override
    public void useItem(Tile t) {
        t.onShovel();
    }
}
