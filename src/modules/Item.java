package modules;

public abstract class Item {

    protected Tile tile;
    protected Player player;

    public Item(){}
    public Item(Player player) { this.player = player; }
    public Item(Tile tile){ this.tile = tile; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public Tile getTile() { return tile; }

    public abstract void useItem(Tile t);
}