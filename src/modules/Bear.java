package modules;

import gui.IDrawable;
public class Bear  {

    private Tile position;
    public Bear(Tile position) {this.position = position;}
    public Tile getPosition() {
        return this.position;
    }

    public void move(Tile t) {
        position = t;
        t.onBearStep();
    }


}
