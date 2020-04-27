package modules;

public abstract class Item {

    protected Tile tile;
    protected Player player;

    public Item(Player player) { this.player = player; }
    public  Item(Tile tile){ this.tile = tile; }

    public Player getPlayer() { return player; }
    public Tile getTile() { return tile; }

    public abstract void useItem(Tile t);
}