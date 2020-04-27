package modules;

public abstract class Item
{
    Tile tile;
    Player player;

    public Item() {}
    public Item(Tile t, Player p) {
        this.tile = tile;
        this.player = player;
    }

    public Item getItem() {
        System.out.println( this.toString() + "getItem was called");
        return this;
    }
    public void useItem(Tile t) {
        System.out.println( this.toString() + "useItem was called with param: " + t.toString());
    }
}