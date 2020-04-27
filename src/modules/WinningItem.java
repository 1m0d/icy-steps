package modules;

public class WinningItem extends Item
{
    public WinningItem(Tile t, Player p) {
        super(t, p);
    }

    public WinningItem() {}

    @Override
    public void useItem(Tile t)
    {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
        GameController.getInstance().checkWinningConditions();
    }
}
