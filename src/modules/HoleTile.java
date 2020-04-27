package modules;

public class HoleTile extends Tile {
    public HoleTile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, playerCapacity, snowLayerCount, uniqueID);
    }

    public void onPlayerStep(Player p) {
        players.add(p);
        p.onHole();
    }

    public void onRope() {
        players.clear();
    }

    @Override
    public void onBearStep(){
        if(!players.isEmpty())
            GameController.getInstance().lose();
    }

    @Override
    public void onStorm() {
        for (Player player : players ) {
            player.damage();
        }
    }
}