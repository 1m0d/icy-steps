package modules;

public abstract class Item {

    Tile tile;
    Player player;

    public Item() {}
    public Item(Tile t, Player p) {
        tile = t;
        player = p;
    }
    public abstract void useItem(Tile t);
}