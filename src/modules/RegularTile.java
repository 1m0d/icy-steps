package modules;

public class RegularTile extends Tile {
    protected boolean igloobuilt;
    protected boolean campbuilt;

    public RegularTile(String token, String token1, String token2, String token3, String token4) {
        super(Integer.parseInt(token), Integer.parseInt(token1), Integer.parseInt(token4));
        igloobuilt = Boolean.parseBoolean(token2);
        campbuilt = Boolean.parseBoolean(token3);
    }

    @Override
    public void onRope() {

    }

    @Override
    public void onPlayerStep(Player p) {
        System.out.println( this.toString() + " onPlayerStep was called with param: " + p);
    }

    @Override
    public void onTurn() {

    }

    @Override
    public void onShovel()
    {
        System.out.println( this.toString() + " onShovel was called");
    }

    @Override
    public void onStorm()
    {
        System.out.println( this.toString() + " onStorm was called");
    }

    @Override
    public void flip() {
        System.out.println( this.toString() + "flip was called");
        GameController.getInstance().lose();
    }
}