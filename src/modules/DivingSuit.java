package modules;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class DivingSuit extends Item
{
    public BufferedImage dsImage;
    public DivingSuit(){}
    public DivingSuit(Player player) { super(player); }
    public DivingSuit(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        if (player != null) {
            player.hasDivingSuit = true;
        }
    }

    @Override
    public String toString(){
        return "diving-suit";
    }


    @Override
    public void Draw(JPanel jp) {

    }

    @Override
    public BufferedImage getImage() {
        return dsImage;
    }
}
