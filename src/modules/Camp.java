package modules;

/**
 * A tabor osztalya, az Itembol szarmazik le
 */
public class Camp extends Item {

    /**
     * Konstruktorok
     */
    public Camp(){}

    public Camp(Player player) { super(player); }
    public Camp(Tile tile) { super(tile); }


    /**
     *Tabort epit az adott mezore
     */
    public void useItem(Tile t) { ((RegularTile)t).buildCamp(); }
}
