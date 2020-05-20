package modules;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    protected boolean activePlayer = false;
    protected boolean hasDivingSuit = false;


    public BufferedImage image;



    /**
     * Visszater a jatekos azonositojaval
     */
    public int getUniqueID(){ return uniqueID; }
    public int getEnergy() { return energy; }
    public int getLives() { return lives; }
    public boolean isDrowning() { return drowning; }
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
        if(drowning) {
            if (!hasDivingSuit){
                GameController.getInstance().lose();
            }
            pass();
        }
        else {
            energy = 4;
            activePlayer = true;
        }
    }

    /**
     *A jatekos az adott mezore lepp
     */
    public void step(Tile t) {
        position.removePlayer(this);
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

    public void useItem(Item item, Tile tile){
        item.useItem(tile);
        work();
    }

    public abstract void useAbility(Tile t);

    public void onFood() {
        if (lives < maxLives) {
            lives++;
        }
        work();
    }

    public void onHole() {
        drowning = true;
        energy = 0;
    }

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

    public void loadImages(String path)
    {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "lives " + lives + " energy: " + energy;
    }

}

