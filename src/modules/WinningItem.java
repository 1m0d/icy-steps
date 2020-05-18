package modules;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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


    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
