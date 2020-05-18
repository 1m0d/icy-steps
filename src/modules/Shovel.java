package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Shovel extends Item
{

    public Shovel(){}
    public Shovel(Player player) {
        super(player);
        super.loadImages("src/gui/icons/bear.jpg");
    }
    public Shovel(Tile tile) {
        super(tile);
        super.loadImages("src/gui/icons/bear.jpg");
    }

    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }

    @Override
    public String toString(){
        return "shovel";
    }


}
