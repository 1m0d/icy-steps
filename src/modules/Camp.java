package modules;

public class Camp extends Item {


    public Camp(Player player) { super(player); }

    public Camp(Tile tile) { super(tile); }

    public void useItem(Tile t) { ((RegularTile)t).buildCamp(); }
}
