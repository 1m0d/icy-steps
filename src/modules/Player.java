package modules;

import java.util.ArrayList;
import java.util.List;
/**
 * A jatekosok absztrakt osztalya, ebbol szarmazik le az eszkimo es a tudos
 */
public abstract class Player {
    protected Tile position;

    protected int maxLives;
    protected int energy = 5;
    protected int lives;
    protected boolean drowning = false;
    protected int uniqueID;
    protected ArrayList<Item> items = new ArrayList<>();
    protected int nOfWinningItems = 0;
    protected boolean activePlayer = false;
    protected boolean hasDivingSuit = false;

    /**
     * Visszater a jatekos azonositojaval
     */
    public int getUniqueID(){ return uniqueID; }
    public int getEnergy() { return energy; }
    public int getLives() { return lives; }
    public boolean isDrowning() { return drowning; }
    public int getnOfWinningItems() { return nOfWinningItems; }
    public boolean isActivePlayer() { return activePlayer; }
    public boolean isHasDivingSuit() { return hasDivingSuit; }

    /**
     *Konstruktorok
     */
    public Player(Tile position) { this.position = position; }

    public Player(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        this.position = position;
        this.energy = energy;
        this.lives = lives;
        this.drowning = drowning;
        this.uniqueID = uniqueID;
    }

    public void setActivePlayer(boolean activePlayer) { this.activePlayer = activePlayer; }

    /**
     *Berakja az adott itemet a jatekos inveontory-jaba
     */
    public void addItemToInventory(Item i) { items.add(i); }

    /**
     *Csokkenti a jatekos energiajat, amíg nem nulla, addig tart a jatekos kore
     */
    protected void work() {
        if(--energy <= 0) {
            activePlayer = false;
            GameController.getInstance().endPlayerTurn();
        }
    }

    /**
     *A jatekos kore elkezdodik, kezdetben 4 az energiaja
     */
    public void startTurn() {
        energy = 4;
        activePlayer = true;
        if(drowning && !hasDivingSuit){
            GameController.getInstance().lose();
        }
    }

    /**
     *A jatekos az adott mezore lepp
     */
    public void step(Tile t) {
        position = t;
        t.onPlayerStep(this);
        work();
    }
    /**
     *A jatekos tovabbadja a koret a kovetkezo jatekosnak
     */
    public void pass() {
        activePlayer = false;
        energy = 0;
        GameController.getInstance().endPlayerTurn();
    }

    /**
     *A jatekos
     */
    // TODO useItem(Tile)
    public void useItem(Item i) {
        i.useItem(position);
        work();
    }

    public abstract void useAbility(Tile t);

    public void onFood() {
        if (lives < maxLives) {
            lives++;
        }
        work();
    }

    public void onHole() { drowning = true; }

    public void getPulledTo(Tile t) {
        position = t;
        t.onPlayerStep(this);
    }

    public void clearSnow() {
        RegularTile t = (RegularTile)position;
        t.clearSnow();
        work();
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

     public void pickUpItem(){
         Item item = ((RegularTile)position).getItem();
         if(item == null)
             return;
         addItemToInventory(item);
         item.setPlayer(this);
         ((RegularTile) position).setItem(null);
         work();
     }
}

