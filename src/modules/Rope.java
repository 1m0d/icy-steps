package modules;

public class Rope extends Item {

    public Rope(){}
    public Rope(Player player) { super(player); }
    public Rope(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        for (Player p : t.getPlayers())
        {
            p.getPulledTo(t);
        }
        ((HoleTile)t).onRope();
    }
}
