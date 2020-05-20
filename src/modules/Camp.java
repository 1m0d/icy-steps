package modules;

public class Camp extends Item {

    public Camp() {
    }

    public Camp(Player player) {
        super(player);
        super.loadImages("src/gui/icons/camp.png");
    }

    public Camp(Tile tile) {
        super(tile);
        super.loadImages("src/gui/icons/camp.png");

    }

    @Override
    public void useItem(Tile t) {
        ((RegularTile) t).buildCamp();
    }

    @Override
    public String toString() {
        return "camp";
    }

}
