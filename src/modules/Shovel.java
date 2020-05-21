package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *az ásó eszközök osztálya, au Itemből származik le
 */
public class Shovel extends Item
{
    /**
     *konstruktorok
     */
    public Shovel(){}
    public Shovel(Player player) {
        super(player);
        super.loadImages("src/gui/icons/bear.png");
    }
    public Shovel(Tile tile) {
        super(tile);
        super.loadImages("src/gui/icons/bear.png");
    }

    /**
     *meghívja a hólapátolásért felelős függvényt
     */
    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }

    @Override
    public String toString(){
        return "shovel";
    }


}
