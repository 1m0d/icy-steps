package modules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;

public class RegularTile extends Tile {
    private boolean iglooBuilt = false;
    private boolean campBuilt = false;
    private Item item;
    private BufferedImage rtGroundImage;
    private BufferedImage rtIceImage;

    public RegularTile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, playerCapacity, snowLayerCount, uniqueID);
        loadImages();
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
            GameModel.getInstance().lose();
    }

    @Override
    public void onStorm() {
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
        GameModel.getInstance().lose();
    }

    @Override
    public void Draw(JPanel jp) {

        JPanel pane = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (item != null)
                {
                    System.out.println("itemrajzolás hívás");
                    g.drawImage(item.image,0,0,null);
                    g.drawRect(10,10,30,30);
                }

                if(snowLayerCount == 0)
                {
                    g.drawImage(rtGroundImage,0,0,null);
                    //g.drawImage(item.image,0,0,null);

                }
                else
                {
                    g.drawImage(rtIceImage,0,0,null);
                }

                for(Player p: players)
                {
                    g.drawImage(p.image,getWidth()/4,0,null);
                }
            }
        };

        jp.add(pane);

    }

    public void loadImages()
    {
        try {
            rtGroundImage = ImageIO.read(new File("src/gui/icons/ground.jpg"));
            rtIceImage = ImageIO.read(new File("src/gui/icons/ice.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}