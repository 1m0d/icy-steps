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

    public Scientist(Tile position) {
        super(position);
    }

    public Scientist(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
        maxLives = 4;
        super.loadImages("src/gui/icons/scientist.png");
    }

    @Override
    public void useAbility(Tile t) {
        t.onScientistAbility();
        work();
    }


}