package modules;

public class Food extends Item {

    public Food() {}
    public Food(Player player) { super(player); }
    public Food(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        if (player.lives < player.maxLives) {
            player.lives++;
        }
    }
}
