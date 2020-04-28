package modules;

import java.util.ArrayList;
import java.util.List;

public abstract class Player
{
    public static int maxLives;
    protected Tile position;

    protected int energy = 5;
    protected int lives;
    protected boolean drowning = false;
    protected int uniqueID;
    protected ArrayList<Item> items = new ArrayList<>();
    protected int nOfWinningItems = 0;
    protected boolean activePlayer = false;

    protected boolean hasDivingSuit = false;

    public int getUniqueID(){ return uniqueID; }
    public int getEnergy() { return energy; }
    public int getLives() { return lives; }
    public boolean isDrowning() { return drowning; }
    public int getnOfWinningItems() { return nOfWinningItems; }
    public boolean isActivePlayer() { return activePlayer; }
    public boolean isHasDivingSuit() { return hasDivingSuit; }

    public Player(Tile position) { this.position = position; }

    public Player(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        this.position = position;
        this.energy = energy;
        this.lives = lives;
        this.drowning = drowning;
        this.uniqueID = uniqueID;
    }

    public void addItemToInventory(Item i) { items.add(i); }

    private void work() {
        if(--energy <= 0) {
            activePlayer = false;
            GameController.getInstance().endPlayerTurn();
        }
    }

    public void startTurn() {
        energy = 5;
        activePlayer = true;
        if(drowning && !hasDivingSuit){
            GameController.getInstance().lose();
        }
    }

    public void step(Tile t) {
        position = t;
        t.onPlayerStep(this);
    }

    public void pass() {
        activePlayer = false;
        GameController.getInstance().endPlayerTurn();
    }

    // TODO useItem(Tile)
    public void useItem(Item i) { i.useItem(position); }

    public abstract void useAbility(Tile t);

    public void onFood() {
        if (lives < maxLives) {
            lives++;
        }
    }

    public void onHole() { drowning = true; }

    public void getPulledTo(Tile t) {
        position = t;
        t.onPlayerStep(this);
    }

    public void clearSnow() {
        RegularTile t = (RegularTile)position;
        t.clearSnow();
    }

    public void setDivingSuit() { hasDivingSuit = true; }

    public void damage() {
        lives--;
        if(lives <= 0)
            GameController.getInstance().lose();
    }

     public int getWinningItemN() { return nOfWinningItems;}

     public Tile getPosition() {
         return this.position;
     }

     public ArrayList<Item> getItems(){
        return items;
     }
}

