package modules;

import java.awt.*;

public class Shovel extends Item
{
    private Image rtImage;

    public Shovel(){}
    public Shovel(Player player) { super(player); }
    public Shovel(Tile tile) { super(tile); }


    @Override
    public void useItem(Tile t) {
        ((RegularTile)t).onShovel();
    }

    @Override
    public String toString(){
        return "shovel";
    }


}
