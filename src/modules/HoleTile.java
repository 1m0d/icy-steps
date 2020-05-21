package modules;

import javax.swing.*;
import java.awt.*;

/**
 *a lyukas mezők osztálya, a Tile-ból származik le
 */
public class HoleTile extends Tile {

    /**
     *konstruktor
     */
    public HoleTile(int positionX, int positionY, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, 0, snowLayerCount, uniqueID);
        super.loadImages("src/gui/icons/water.png");
    }

    /**
     *a játékos rálép a mezőre
     */
    public void onPlayerStep(Player p) {
        players.add(p);
        p.onHole();
        snowLayerCount = 0;
    }

    /**
     *ha egy játékost kihúznak a vízből
     */
    public void onRope() {
        players.clear();
    }

    /**
     *rálép a medve a mezőre
     */
    @Override
    public void onBearStep(){
        if(!players.isEmpty())
            GameController.getInstance().lose();

        snowLayerCount = 0;
    }

    /**
     *vihar van a mezőn
     */
    @Override
    public void onStorm() {
        for (Player player : players ) {
            player.damage();
        }
    }
}