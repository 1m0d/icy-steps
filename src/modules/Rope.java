package modules;

public class Rope extends Item {
    public Rope(Tile t, Player p) {
        super(t, p);
    }
    public Rope() {}

    @Override
    public void useItem(Tile t) {
        System.out.println( this.toString() + " useItem was called with param: " + t.toString());
        t.onRope();
    }
}
