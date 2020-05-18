package modules;

import gui.IDrawable;

/**
 * Az eszkozok absztrakt osztalya, ebbol szarmazik le minden eszkoz
 */
public abstract class Item  implements IDrawable{

    protected Tile tile;
    protected Player player;

    /**
     *Konstruktorok
     */
    public Item(){}
    public Item(Player player) { this.player = player; }
    public Item(Tile tile){ this.tile = tile; }

    /**
     *Visszater azzal a jatekossal, aki birtokolja
     */
    public Player getPlayer() { return player; }

    /**
     *Beallitja, hogy melyik jatekos birtokolja
     */
    public void setPlayer(Player player) { this.player = player; }

    /**
     *Visszater azzal a mezovel, amelyiken van
     */
    public Tile getTile() { return tile; }

    public abstract void useItem(Tile t);
}