package modules;

public class HoleTile extends Tile {
    public HoleTile(String token, String token1, String token2, String token3, String token4) {
        super(Integer.parseInt(token), Integer.parseInt(token1), Integer.parseInt(token4));
    }

    public void setItem(Item newItem)
    {
        super.setItem(null);
    }

    public void onPlayerStep(Player p) {
        System.out.println( this.toString() + "onPlayerStep was called with param: " + p.toString());
        p.onHole();
    }

    @Override
    public void onTurn() {

    }

    @Override
    public void onRope()
    {
        System.out.println( this.toString() + "onRope was called");
    }
}