package modules;

import java.util.ArrayList;

public abstract class Tile {
    protected int positionX;
    protected int positionY;
    protected int uniqueID;
    protected int playerCapacity;
    protected boolean scientistChecked = false;
    protected int snowLayerCount;

    protected ArrayList<Player> players = new ArrayList<>();

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
}
