package modules;

public class Food extends Item {
    public Food(Tile t, Player p) {
        super(t, p);
    }
    public Food() {}

    @Override
    public void useItem(Tile t) {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
    }
}
