package modules;

public class Scientist extends Player {

    public Scientist(Tile position) {
        super(position);
    }

    public Scientist(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
    }

    @Override
    public void useAbility(Tile t) { t.onScientistAbility(); }
}