package modules;

import gui.MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *A mezők absztrakt ősoztálya, ebből származik le a Hole Tile és a Regular Tile
 */
public abstract class Tile{
    protected int positionX;
    protected int positionY;
    protected int uniqueID;
    protected int playerCapacity;
    protected boolean scientistChecked = false;
    protected int snowLayerCount;
    protected ArrayList<Player> players = new ArrayList<>();
    public BufferedImage image;
    private static int tileWidth;
    private static int tileHeight;

    /**
     *absztrakt függvények, amik csak a leszármazottakban valósulnak meg
     */
    public abstract void onPlayerStep(Player p);
    public abstract void onBearStep();
    public abstract void onStorm();

    /**
     *konstuktor
     */
    public Tile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.playerCapacity = playerCapacity;
        this.snowLayerCount = snowLayerCount;
        this.uniqueID = uniqueID;
    }

    /**
     *getterek
     */
    public int getUniqueID(){ return uniqueID; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public int getPlayerCapacity() { return playerCapacity; }
    public boolean isScientistChecked() { return scientistChecked; }
    public int getSnowLayerCount() { return snowLayerCount; }
    public ArrayList<Player> getPlayers() { return players; }
    public static int getTileWidth() { return tileWidth; }
    public static int getTileHeight() { return tileHeight; }

    /**
     *megnézi a tudós, hogy hány ember fér el egy mezőn
     */
    public void onScientistAbility() { scientistChecked = true; }

    /**
     *hozzáadja a játékost a mezőre
     */
    public void addPlayer(Player player) { players.add(player); }

    /**
     *eltávolítja a játékost a mezőről
     */
    public void removePlayer(Player player) {players.remove(player);}

    /**
     *betölti a megfelelő képeket
     */
    public void loadImages(String path)
    {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *kiszámolja, hogy mekkora a térkép
     */
    public static void calculateTileDimensions(){
        tileHeight = MainFrame.getFrameHeight() / GameController.getInstance().getMap().getRowCount();
        tileWidth = MainFrame.getFrameWidth() / GameController.getInstance().getMap().getColumnCount();
    }

    /**
     *megnézi, hogy hol van a medve
     */
    public boolean checkBear() {
        return GameController.getInstance().getBear().getPosition() == this;
    }
}
