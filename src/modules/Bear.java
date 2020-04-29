package modules;

/**
 * A medve osztalya
 */
public class Bear {
    /**
     * A medve pozicioja
     */
    private Tile position;

    /**
     * Konstruktor
     */
    public Bear(Tile position) {this.position = position;}

    /**
     * Ez mozgatja a medvet
     */
    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }

    /**
     * Visszater a medve poziciojaval
     */
    public Tile getPosition() {
        return this.position;
    }
}
