package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Rope extends Item {

    private Image rtImage;
    public BufferedImage rImage;
    public Rope(){}
    public Rope(Player player) { super(player); }
    public Rope(Tile tile) { super(tile); }

    @Override
    public void useItem(Tile t) {
        ArrayList<Player> playersInHole = t.getPlayers();
        for (Player player : playersInHole) {
            player.getPulledTo(this.player.getPosition());
        }
        ((HoleTile)t).onRope();
    }

    @Override
    public String toString(){
        return "rope";
    }


    public void loadImages()
    {
        try {
            rImage = ImageIO.read(new File("src/gui/icons/rope.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
