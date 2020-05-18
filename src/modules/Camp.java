package modules;

import gui.IDrawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Camp extends Item {

    public BufferedImage cImage;
    public Camp(){}

    public Camp(Player player) { super(player); }
    public Camp(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) { ((RegularTile)t).buildCamp(); }

    @Override
    public String toString(){
        return "camp";
    }

    public void loadImages()
    {
        try {
            cImage = ImageIO.read(new File("src/gui/icons/camp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return cImage;
    }
}
