package modules;

public class Scientist extends Player
{

    public Scientist(int Id)
    {
        super();
    }

    public Scientist(Tile t, String token1, String token2, String token3, String token4) {
        super(t, token1, token2, token3, token4);
    }

    @Override
    public void turn()
    {
        System.out.println( this.toString() + "turn was called");
    }

    @Override
    public void useAbility(Tile t)
    {
        System.out.println( this.toString() + " useAbility was called with param: " + t.toString());
        t.onScientistAbility();
    }
}