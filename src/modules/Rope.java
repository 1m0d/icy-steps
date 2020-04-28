package modules;
/**
 * A kotel objektumok osztalya, az Itembol szarmazik le
 */
public class Rope extends Item {
    /**
     *Konstruktorok
     */
    public Rope(){}
    public Rope(Player player) { super(player); }
    public Rope(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja, ennek a segítsegevel lehet egy jatekost kimenekiteni a vizbol
     */
    @Override
    public void useItem(Tile t) {
        for (Player p : t.getPlayers())
        {
            p.getPulledTo(t);
        }
        ((HoleTile)t).onRope();
    }

    @Override
    public String toString(){
        return "rope";
    }
}
