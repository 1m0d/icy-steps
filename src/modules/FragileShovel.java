package modules;

public class FragileShovel extends Shovel {

    private int durability = 3;

    public FragileShovel(Player player) { super(player); }

    public FragileShovel(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        if (durability >= 1)
        {
            ((RegularTile)t).onShovel();
            durability--;
        }
    }

}
