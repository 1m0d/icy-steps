package modules;

public class Eskimo extends Player
{
    public Eskimo(int Id)
    {
        super();
    }

    @Override
    public void work()
    {
        System.out.println( this.toString() + " work was called");
    }

    @Override
    public void turn()
    {
        System.out.println( this.toString() + " turn was called");
    }

    @Override
    public void step(Tile t)
    {
        System.out.println( this.toString() + " step was called with param: " + t.toString());
    }

    @Override
    public void pass()
    {
        System.out.println( this.toString() + " pass was called");
    }

    @Override
    public void pickUpItem()
    {
        System.out.println( this.toString() + " pickUpItem was called");
    }

    @Override
    public void useItem(Item i)
    {
        System.out.println( this.toString() + " useItem was called with param: " + i.toString());
    }

    @Override
    public void useAbility(Tile t)
    {
        System.out.println( this.toString() + " useAbility was called with param: " + t.toString());
        t.onEskimoAbility();

    }

    @Override
    public void onStorm()
    {
        System.out.println( this.toString() + " onStorm was called");
    }

    @Override
    public void onFood()
    {
        System.out.println( this.toString() + " onFood was called");
    }

    @Override
    public void onHole()
    {
        System.out.println( this.toString() + " onHole was called");
    }

    @Override
    public void getPulledTo(Tile t)
    {
        System.out.println( this.toString() + " getPulledTo was called with param: " + t.toString());
    }

    @Override
    public void clearSnow()
    {
        System.out.println( this.toString() + " clearSnow was called");
    }
}
