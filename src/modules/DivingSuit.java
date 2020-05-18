package modules;

public class DivingSuit extends Item
{
    public DivingSuit(){}
    public DivingSuit(Player player)
    {
        super(player);
        super.loadImages("src/gui/icons/divingsuit.gif");
    }
    public DivingSuit(Tile tile) { super(tile); }

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
