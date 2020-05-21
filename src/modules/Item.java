package modules;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Az eszkozok absztrakt osztalya, ebbol szarmazik le minden eszkoz
 */
public abstract class Item {
    protected Tile tile;
    protected Player player;
    private BufferedImage image;

    /**
     *Konstruktorok
     */
    public Item(){}
    public Item(Player player) { this.player = player; }
    public Item(Tile tile){ this.tile = tile; }

    /**
     *Visszater azzal a jatekossal, aki birtokolja
     */
    public Player getPlayer() { return player; }

    /**
     *Beallitja, hogy melyik jatekos birtokolja
     */
    public void setPlayer(Player player) { this.player = player; }

    /**
     *Visszater azzal a mezovel, amelyiken van
     */
    public Tile getTile() { return tile; }

    public abstract void useItem(Tile t);

    /**
     *betölti a megfelelő képeket
     */
    public void loadImages(String path)
    {
        try {
            image = ImageIO.read(new File(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(){ return image; }
}