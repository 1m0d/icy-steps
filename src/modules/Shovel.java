package modules;

/**
 *Az aso objektumok osztalya, az Itembol szarmazik le
 */
public class Shovel extends Item
{

    /**
     *Konstruktorok
     */
    public Shovel(){}
    public Shovel(Player player) { super(player); }
    public Shovel(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja,  ez hivja meg a holapatolasert felelos fuggvenyt
     */
    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }

    @Override
    public String toString(){
        return "shovel";
    }
}
