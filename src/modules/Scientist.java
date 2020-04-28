package modules;

/**
 * Az eszzkimo tipusu jatekosok osztalya, a Playerbol szarmazik le
 */
public class Scientist extends Player {
    /**
     * Konstruktorok
     */
    public Scientist(Tile position) {
        super(position);
    }

    public Scientist(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
    }

    /**
     * a Player useAbility fuggvenyenek override-ja, egy adott Tile-t ellenoriz, hogy hany ember fer el rajta
     */
    @Override
    public void useAbility(Tile t) {
        t.onScientistAbility();
        work();
    }
}