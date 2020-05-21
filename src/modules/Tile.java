package modules;

import gui.MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    public abstract void onPlayerStep(Player p);
    public abstract void onBearStep();
    public abstract void onStorm();

    public Tile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.playerCapacity = playerCapacity;
        this.snowLayerCount = snowLayerCount;
        this.uniqueID = uniqueID;
    }

    public int getUniqueID(){ return uniqueID; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public int getPlayerCapacity() { return playerCapacity; }
    public boolean isScientistChecked() { return scientistChecked; }
    public int getSnowLayerCount() { return snowLayerCount; }
    public ArrayList<Player> getPlayers() { return players; }
    public static int getTileWidth() { return tileWidth; }
    public static int getTileHeight() { return tileHeight; }

    public void onScientistAbility() { scientistChecked = true; }
    public void addPlayer(Player player) { players.add(player); }
    public void removePlayer(Player player) {players.remove(player);}

    public void loadImages(String path)
    {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculateTileDimensions(){
        tileHeight = MainFrame.getFrameHeight() / GameController.getInstance().getMap().getRowCount();
        tileWidth = MainFrame.getFrameWidth() / GameController.getInstance().getMap().getColumnCount();
    }

    public boolean checkBear() {
        return GameController.getInstance().getBear().getPosition() == this;
    }
}
