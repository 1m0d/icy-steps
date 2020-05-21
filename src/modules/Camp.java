package modules;
/**
 *a sátor eszközökért felelős osztály, az Itemből származik le
 */
public class Camp extends Item {

    public Camp() {
    }
    /**
     *konsturktorok
     */
    public Camp(Player player) {
        super(player);
        super.loadImages("src/gui/icons/camp.png");
    }

    public Camp(Tile tile) {
        super(tile);
        super.loadImages("src/gui/icons/camp.png");

    }
    /**
     *sátor felálíltása a mezőn
     */
    @Override
    public void useItem(Tile t) {
        ((RegularTile) t).buildCamp();
    }

    @Override
    public String toString() {
        return "camp";
    }

}
