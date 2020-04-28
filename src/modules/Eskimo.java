package modules;

public class Eskimo extends Player {

    public Eskimo(Tile position) {
        super(position);
    }

    public Eskimo(Tile position, int energy, int lives, boolean drowning, int uniqueID) {
        super(position, energy, lives, drowning, uniqueID);
    }

    @Override
    public void useAbility(Tile t) {
        ((RegularTile)position).buildIgloo();
        work();
    }
}
