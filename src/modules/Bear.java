package modules;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bear {

    public BufferedImage image;
    private Tile position;

    public Bear(Tile position) {
        this.position = position;
        loadImages();
    }

    public Tile getPosition() {
        return this.position;
    }

    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }

    public void loadImages() {
        try {
            image = ImageIO.read(new File("src/gui/icons/bear.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
