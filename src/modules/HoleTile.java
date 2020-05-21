package modules;

import javax.swing.*;
import java.awt.*;

public class HoleTile extends Tile {

    public HoleTile(int positionX, int positionY, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, 0, snowLayerCount, uniqueID);
        super.loadImages("src/gui/icons/water.png");
    }

    public void onPlayerStep(Player p) {
        players.add(p);
        p.onHole();
        snowLayerCount = 0;
    }

    public void onRope() {
        players.clear();
    }

    @Override
    public void onBearStep(){
        if(!players.isEmpty())
            GameController.getInstance().lose();

        snowLayerCount = 0;
    }

    @Override
    public void onStorm() {
        for (Player player : players ) {
            player.damage();
        }
    }
}