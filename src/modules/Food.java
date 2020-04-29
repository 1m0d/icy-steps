package modules;

/**
 * Az elelmek osztalya, az Itembol szarmazik le
 */
public class Food extends Item {

    /**
     * Konstruktorok
     */
    public Food() {}
    public Food(Player player) { super(player); }
    public Food(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja, a jatekos eleten novel egyet, amennyiben annak nem maximalis az elete
     */
    @Override
    public void useItem(Tile t) {
        if (player.lives < player.maxLives) {
            player.lives++;
        }
    }

    @Override
    public String toString(){
        return "food";
    }
}
