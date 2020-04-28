package modules;

/**
 * Az eszzkimo tipusu jatekosok osztalya, a Playerbol szarmazik le
 */
public class Eskimo extends Player {

    /**
     * Konstruktorok
     */
    public Eskimo(Tile position) {
        super(position);
    }

    public Eskimo(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
    }

    /**
     * a Player useAbility fuggvenyenek override-ja, iglut epit az adott mezore
     */
    @Override
    public void useAbility(Tile t) {
        ((RegularTile)position).buildIgloo();
        work();
    }
}
