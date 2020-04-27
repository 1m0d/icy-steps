package modules;

import java.util.List;

public abstract class Player
{
    public static int maxLives;
    protected Tile position;
    protected int energy;
    protected int lives;
    protected boolean drowning = false;
    protected int uniqueID;
    protected List<Item> items;
    int nOfWinningItems = 0;

    protected boolean hasDivingSuit = false;

    public int getUniqueID(){
        return uniqueID;
    }

    public Player(Tile position) { this.position = position; }

    public Player(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        this.position = position;
        this.energy = energy;
        this.lives = lives;
        this.drowning = drowning;
        this.uniqueID = uniqueID;
    }

    public void addItemToInventory(Item i) { items.add(i); }

    boolean work()
    {
        System.out.println( this.toString() + " work was called");
        if(energy != 0)
        {
            energy--;
            return true;
        }

        System.out.println("You don't have more energy");
        return false;
    }

    // TODO: WTF
    public void turn() {
        System.out.println( this.toString() + " turn was called");
        while(energy != 0){
            work();
        }
    }

    public void step(Tile t) {
        position = t;
        t.onPlayerStep(this);
    }

    // TODO
    public void pass() { energy=0; }

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
}

