package modules;

/**
 * a nyero objektumok osztalya, az Itembol szarmazik le
 */
public class WinningItem extends Item {

    /**
     * Konstruktorok
     */
    public WinningItem(){}
    public WinningItem(Player player) { super(player); }
    public WinningItem(Tile tile) { super(tile); }

    /**
     *Item osztaly useItem fuggvenyet override-olja,  meghivja a GameControllernek azt a fuggvenyet, ami ellenorzi, hogy
     * a jatekosok nyertek-e
     */
    @Override
    public void useItem(Tile t) {
        GameController.getInstance().checkWinningConditions();
    }

    @Override
    public String toString(){
        return "winning-item";
    }
}
