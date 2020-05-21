package modules;

/**
 * Az eszzkimo tipusu jatekosok osztalya, a Playerbol szarmazik le
 */
public class Eskimo extends Player  {

    public Eskimo(Tile position) {
        super(position);
    }
    /**
     *konstuktor
     */
    public Eskimo(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
        maxLives = 5;
        super.loadImages("src/gui/icons/eskimo.png");
    }

    /**
     *iglut épít az adott mezőn
     */
    @Override
    public void useAbility(Tile t) {
        ((RegularTile)position).buildIgloo();
        work();
    }
}
