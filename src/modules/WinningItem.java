package modules;

public class WinningItem extends Item {
    public WinningItem(){}
    public WinningItem(Player player) { super(player); }
    public WinningItem(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        GameController.getInstance().checkWinningConditions();
    }
}
