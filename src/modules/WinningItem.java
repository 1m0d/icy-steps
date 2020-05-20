package modules;


public class WinningItem extends Item {

    public WinningItem(){}
    public WinningItem(Player player) { super(player); }
    public WinningItem(Tile tile) { super(tile);
        super.loadImages("src/gui/icons/winning-item.png");}

    @Override
    public void useItem(Tile t) {
        GameController.getInstance().checkWinningConditions();
    }

    @Override
    public String toString(){
        return "winning-item";
    }



}
