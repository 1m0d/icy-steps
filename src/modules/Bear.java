package modules;

public class Bear {

    Tile position;
    public void move(Tile t) {
        t.onBearStep();
    }
}
