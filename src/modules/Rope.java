package modules;

public class Rope extends Item {
    public Rope(Tile t, Player p) {
        super(t, p);
    }
    public Rope() {}

    @Override
    public void useItem(Tile t) {
        for (Player p : t.getPlayers())
        {
            p.position = this.tile;
        }
        t.onRope();
    }
}
