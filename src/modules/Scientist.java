package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az eszzkimo tipusu jatekosok osztalya, a Playerbol szarmazik le
 */
public class Scientist extends Player {

    public BufferedImage scImage;
    public Scientist(Tile position) {
        super(position);
    }

    public Scientist(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
        maxLives = 4;
        loadImages();
    }


    @Override
    public void useAbility(Tile t) {
        t.onScientistAbility();
        work();
    }
    
    public void loadImages()
    {
        try {
            scImage = ImageIO.read(new File("src/gui/icons/scientist.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return scImage;
    }
}