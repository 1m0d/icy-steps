package modules;

public class Shovel extends Item
{

    public Shovel(){}
    public Shovel(Player player) { super(player); }
    public Shovel(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }
}
