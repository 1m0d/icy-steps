package modules;

import gui.IDrawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bear implements IDrawable {

    public BufferedImage bImage;
    private Tile position;
    public Bear(Tile position) {this.position = position;}
    public Tile getPosition() {
        return this.position;
    }

    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }

    public void loadImages()
    {
        try {
            bImage = ImageIO.read(new File("src/gui/icons/bear.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return bImage;
    }


}
