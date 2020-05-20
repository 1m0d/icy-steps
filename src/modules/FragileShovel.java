package modules;


import java.awt.image.BufferedImage;

/**
 *A torekeny aso objektumok osztalya, az asobol szarmazik le (ami meg az Itembol)
 */
public class FragileShovel extends Shovel {

    private int durability = 3;
    public BufferedImage fsImage;
    /**
     *Konstruktorok
     */
    public FragileShovel(){}
    public FragileShovel(Player player) {
        super(player);
        super.loadImages("src/gui/icons/fragile-shovel.png");
    }
    public FragileShovel(Tile tile) {
        super(tile);
    }

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
