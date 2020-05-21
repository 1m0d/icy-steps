package modules;

import java.awt.image.BufferedImage;

/**
 * Az elelmek osztalya, az Itembol szarmazik le
 */
public class Food extends Item {

    public BufferedImage fImage;
    /**
     * Konstruktorok
     */
    public Food() {}
    public Food(Player player) {
        super(player);
        super.loadImages("src/gui/icons/food.png");
    }
    public Food(Tile tile) {
        super(tile);
        super.loadImages("src/gui/icons/food.png");
    }

    /**
     *növeli a játékos életét, ha az nem a maximális érétken van
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
