package modules;

import java.awt.*;
import java.util.ArrayList;


public class Rope extends Item {

    private Image rtImage;

    public Rope(){}
    public Rope(Player player) { super(player); }
    public Rope(Tile tile) { super(tile); }

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
