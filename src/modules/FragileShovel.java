package modules;

import gui.IDrawable;

/**
 *A torekeny aso objektumok osztalya, az asobol szarmazik le (ami meg az Itembol)
 */
public class FragileShovel extends Shovel {

    private int durability = 3;

    /**
     *Konstruktorok
     */
    public FragileShovel(){}
    public FragileShovel(Player player) { super(player); }
    public FragileShovel(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja, ez hivja meg a holapatolasert felelos fuggvenyt
     */
    @Override
    public void useItem(Tile t) {
        if (durability >= 1)
        {
            ((RegularTile)t).onShovel();
            durability--;
        }
    }

    @Override
    public String toString(){
        return "fragile-shovel";
    }


}
