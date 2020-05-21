package modules;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 *medvéért felelős osztály
 */
public class Bear {

    public BufferedImage image;
    private Tile position;

    /**
     *Konstruktor
     */
    public Bear(Tile position) {
        this.position = position;
        loadImages();
    }

    /**
     *visszatér a medve pozíciójával
     */
    public Tile getPosition() {
        return this.position;
    }

    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }

    /**
     *kép betöltése
     */
    public void loadImages() {
        try {
            image = ImageIO.read(new File("src/gui/icons/bear.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
