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

    public Player() {
    }

    public Player(Tile t, String token1, String token2, String token3, String token4) {
       position = t;
       Integer.parseInt(token1);
       Integer.parseInt(token2);
       Boolean.parseBoolean(token3);
       Integer.parseInt(token4);
    }

    public Player getPlayer() {
        System.out.println( this.toString() + " getPlayer was called");
        return this;
    }

    public void addItemToInventory(Item i)
    {
        System.out.println( this.toString() + " addItemToInventory was called with param: " + i.toString());
        items.add(i);

    }

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

    public void turn()
    {
        System.out.println( this.toString() + " turn was called");
        while(energy != 0){
            work();
        }

    }

    public void step(Tile t) {
        System.out.println( this.toString() + " step was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void pass()
    {
        System.out.println( this.toString() + " pass was called");
        energy=0;
    }

    public void useItem(Item i) {
        System.out.println( this.toString() + " useItem was called with param: " + i.toString());
        i.useItem(position);
    }

    public void useAbility(Tile t) {
        System.out.println( this.toString() + " useAbility was called with param: " + t.toString());

    }

    public void onStorm()
    {
        System.out.println( this.toString() + " onStorm was called");
        position.onStorm();
    }

    public void onFood()
    {
        System.out.println( this.toString() + " onFood was called");
        if (lives < maxLives) {
            lives++;
        }

    }

    public void onHole()
    {
        System.out.println( this.toString() + " onHole was called");
        drowning = true;
    }

    public void getPulledTo(Tile t) {
        System.out.println( this.toString() + " getPulledTo was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void clearSnow()
    {
        System.out.println( this.toString() + " clearSnow was called");
        position.onShovel();

    }

    public void setDivingSuit()
    {
        System.out.println( this.toString() + " setDivingSuit was called");
        hasDivingSuit = true;
    }

    public void damage() {
        lives--;
        }

     public int getWinningItemN() {
         return nOfWinningItems;}

    }

