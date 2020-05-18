package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Shovel extends Item
{
    private Image rtImage;

    public BufferedImage sImage;

    public Shovel(){}
    public Shovel(Player player) { super(player); }
    public Shovel(Tile tile) { super(tile); }


    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }

    @Override
    public String toString(){
        return "shovel";
    }

    public void loadImages()
    {
        try {
            sImage = ImageIO.read(new File("src/gui/icons/shovel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return sImage;
    }
}
