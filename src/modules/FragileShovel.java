package modules;

public class FragileShovel extends Shovel {

    private int durability = 3;

    @Override
    public void useItem(Tile t) {
        if (durability >= 1)
        {
            t.onShovel();
            durability--;
        }
    }

}
