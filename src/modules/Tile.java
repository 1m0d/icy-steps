package modules;

import gui.IDrawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Tile implements IDrawable {
    protected int positionX;
    protected int positionY;
    protected int uniqueID;
    protected int playerCapacity;
    protected boolean scientistChecked = false;
    protected int snowLayerCount;
    protected ArrayList<Player> players = new ArrayList<>();
    public BufferedImage image;

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

    public void onScientistAbility() { scientistChecked = true; }
    public void addPlayer(Player player) { players.add(player); }

    public void loadImages(String path)
    {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
