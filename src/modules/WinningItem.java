package modules;


import java.awt.*;

public class WinningItem extends Item {

    public WinningItem(){}
    public WinningItem(Player player) { super(player); }
    public WinningItem(Tile tile) { super(tile); }
    private Image rtImage;


    @Override
    public void useItem(Tile t) {
        GameModel.getInstance().checkWinningConditions();
    }

    @Override
    public String toString(){
        return "winning-item";
    }


}
