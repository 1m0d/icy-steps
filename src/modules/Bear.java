package modules;

public class Bear {
    private Tile position;

    public Bear(Tile position) {this.position = position;}

    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }
}
