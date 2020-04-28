package modules;

public class Bear {
    private Tile position;

    public Bear (Tile t ) {position = t; }
    public void move(Tile t) {
        t.onBearStep();
    }
}
