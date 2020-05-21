package modules;

/**
 *nyerő eszközök osztálya, az Itemből származik le
 */
public class WinningItem extends Item {

    /**
     *konstruktorok
     */
    public WinningItem(){}
    public WinningItem(Player player) { super(player); }
    public WinningItem(Tile tile) { super(tile);
        super.loadImages("src/gui/icons/winning-item.png");}

    /**
     *eszköz használata, meghívja azt a függvényt, ami ellenőrzi, hogy nyertek-e a játéosok
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
