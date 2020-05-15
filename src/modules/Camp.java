package modules;

import gui.IDrawable;

public class Camp extends Item {

    public Camp(){}

    public Camp(Player player) { super(player); }
    public Camp(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) { ((RegularTile)t).buildCamp(); }

    @Override
    public String toString(){
        return "camp";
    }


}
