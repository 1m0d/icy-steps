package modules;

/**
 * A buvarruha objekctumok osztalya, az Itembol szarmazik le
 */
public class DivingSuit extends Item
{
    /**
     * Konstruktorok
     */
    public DivingSuit(){}
    public DivingSuit(Player player) { super(player); }
    public DivingSuit(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja, a player hasDivingSuit booljat igazra allitja
     */
    @Override
    public void useItem(Tile t) {
        if (player != null) {
            player.hasDivingSuit = true;
        }
    }

    @Override
    public String toString(){
        return "diving-suit";
    }
}
