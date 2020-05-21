package modules;
/**
 *búvárruha eszközök osztálya, az Itemből származik le
 */
public class DivingSuit extends Item
{
    /**
     *konstruktor
     */
    public DivingSuit(){}
    public DivingSuit(Player player)
    {
        super(player);
        super.loadImages("src/gui/icons/diving-suit.png");
    }
    public DivingSuit(Tile tile) { super(tile); }

    /**
     *igazra állítja a hasDivingSuit változót
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
