package modules;

public abstract class Player
{
    public static int maxLives;
    protected Tile position;
    protected int energy;
    protected int lives;
    protected boolean drowning = false;
    protected int uniqueID;

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
        onFood();
        return this;
    }

    public void addItemToInventory(Item i)
    {
        System.out.println( this.toString() + " addItemToInventory was called with param: " + i.toString());
    }

    boolean work()
    {
        System.out.println( this.toString() + " work was called");
        if(energy > 0)
        {
            energy--;
            return true;
        }

        System.out.println("Nincs több energiád!");
        return false;
    }

    public void turn()
    {
        System.out.println( this.toString() + " turn was called");
    }

    public void step(Tile t) {
        System.out.println( this.toString() + " step was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void pass()
    {
        System.out.println( this.toString() + " pass was called");
    }

    public void useItem(Item i) {
        System.out.println( this.toString() + " useItem was called with param: " + i.toString());
    }

    public void useAbility(Tile t) {
        System.out.println( this.toString() + " useAbility was called with param: " + t.toString());
    }

    public void onStorm()
    {
        System.out.println( this.toString() + " onStorm was called");
    }

    public void onFood()
    {
        System.out.println( this.toString() + " onFood was called");
    }

    public void onHole()
    {
        System.out.println( this.toString() + " onHole was called");
    }

    public void getPulledTo(Tile t) {
        System.out.println( this.toString() + " getPulledTo was called with param: " + t.toString());
        t.onPlayerStep(this);
    }

    public void clearSnow()
    {
        System.out.println( this.toString() + " clearSnow was called");
    }

    public void setDivingSuit()
    {
        System.out.println( this.toString() + " setDivingSuit was called");
    }

    public void damage(){}
}
