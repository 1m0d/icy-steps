package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RegularTile extends Tile {
    private boolean iglooBuilt = false;
    private boolean campBuilt = false;
    private Item item;


    public RegularTile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, playerCapacity, snowLayerCount, uniqueID);
    }

    public Item getItem(){ return item; }
    public void setItem(Item item){ this.item = item; }

    public boolean isIglooBuilt() { return iglooBuilt; }
    public boolean isCampBuilt() { return campBuilt; }

    @Override
    public void onPlayerStep(Player p) {
        players.add(p);
        if(players.size() > playerCapacity)
            flip();
    }

    @Override
    public void onBearStep() {
        if(!iglooBuilt && !players.isEmpty())
            GameController.getInstance().lose();
    }

    @Override
    public void onStorm() {
        snowLayerCount++;
        System.out.print(snowLayerCount);
        if(iglooBuilt || campBuilt)
            return;

        for (Player player: players ) {
            player.damage();
        }
    }

    public void onShovel() {
        if(snowLayerCount > 0)
            snowLayerCount -= 2;
    }

    public void clearSnow(){
        if(snowLayerCount > 0)
            snowLayerCount -= 1;
    }

    public void buildIgloo(){ iglooBuilt = true;}
    public void buildCamp(){
        if(!iglooBuilt)
            campBuilt = true;
    }

    private void flip() {
        GameController.getInstance().lose();
    }
}