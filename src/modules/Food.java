package modules;

import gui.IDrawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az elelmek osztalya, az Itembol szarmazik le
 */
public class Food extends Item {

    public BufferedImage fImage;
    /**
     * Konstruktorok
     */
    public Food() {}
    public Food(Player player) { super(player); }
    public Food(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja, a jatekos eleten novel egyet, amennyiben annak nem maximalis az elete
     */
    @Override
    public void useItem(Tile t) {
        if (player.lives < player.maxLives) {
            player.lives++;
        }
    }

    @Override
    public String toString(){
        return "food";
    }

    public void loadImages()
    {
        try {
            fImage = ImageIO.read(new File("src/gui/icons/food.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return fImage;
    }
}
