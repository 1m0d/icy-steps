package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *nem lyukas mezők osztálya a Tile-ból származik le
 */
public class RegularTile extends Tile {
    private boolean iglooBuilt = false;
    private boolean campBuilt = false;
    private Item item;


    /**
     *konstruktor
     */
    public RegularTile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, playerCapacity, snowLayerCount, uniqueID);
    }

    /**
     *getterek
     */
    public Item getItem(){ return item; }
    public void setItem(Item item){ this.item = item; }

    public boolean isIglooBuilt() { return iglooBuilt; }
    public boolean isCampBuilt() { return campBuilt; }

    /**
     *a játékos rálépését kezeli
     */
    @Override
    public void onPlayerStep(Player p) {
        players.add(p);
        if(players.size() > playerCapacity)
            flip();
    }

    /**
     *a medve rálépését kezeli
     */
    @Override
    public void onBearStep() {
        if(!iglooBuilt && !players.isEmpty())
            GameController.getInstance().lose();
    }

    /**
     *ha vihar van, nő a hóréteg száma, és csökken a játékos élete, ha nincs biztonságos helyen
     */
    @Override
    public void onStorm() {
        if (snowLayerCount<6){
        snowLayerCount++;}
        if(iglooBuilt || campBuilt)
            return;

        for (Player player: players ) {
            player.damage();
        }
    }

    /**
     *hólaptálolás, csökken a hó réteg kettővel
     */
    public void onShovel() {
        if(snowLayerCount > 0)
            snowLayerCount -= 2;
    }

    /**
     *eggyel csökken a hóréteg
     */
    public void clearSnow(){
        if(snowLayerCount > 0)
            snowLayerCount -= 1;
    }

    /**
     *iglu építése
     */
    public void buildIgloo(){ iglooBuilt = true;}
    public void buildCamp(){
        if(!iglooBuilt)
            campBuilt = true;
    }

    /**
     *felfordul a mező
     */
    private void flip() {
        GameController.getInstance().lose();
    }
}