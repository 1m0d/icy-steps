package modules;

import java.util.ArrayList;

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
        ArrayList<Player> playersInHole = t.getPlayers();
        for (Player player : playersInHole) {
            player.getPulledTo(this.player.getPosition());
        }
        ((HoleTile)t).onRope();
    }

    @Override
    public String toString(){
        return "rope";
    }
}
