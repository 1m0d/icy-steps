package modules;

/**
 * A tabor objektumok osztalya, az Itembol szarmazik le
 */
public class Camp extends Item {

    /**
     * Konstruktorok
     */
    public Camp(){}

    public Camp(Player player) { super(player); }
    public Camp(Tile tile) { super(tile); }


    /**
     *Item osztaly useItem fuggvenyet override-olja, tabort epit az adott mezore
     */
    @Override
    public void useItem(Tile t) { ((RegularTile)t).buildCamp(); }

    @Override
    public String toString(){
        return "camp";
    }
}
