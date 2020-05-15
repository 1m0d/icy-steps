package modules;

import gui.IDrawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az eszzkimo tipusu jatekosok osztalya, a Playerbol szarmazik le
 */
public class Eskimo extends Player  {

    public BufferedImage eImage;
    public Eskimo(Tile position) {
        super(position);
    }
    public Eskimo(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
        maxLives = 5;
        loadImages();
    }

    public void loadImages()
    {
        try {
            eImage = ImageIO.read(new File("src/gui/icons/eskimo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void useAbility(Tile t) {
        ((RegularTile)position).buildIgloo();
        work();
    }


    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return eImage;
    }
}
