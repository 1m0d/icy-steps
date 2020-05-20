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
    private static BufferedImage rtSnowImage;
    private static BufferedImage rtIceImage;

    public RegularTile(int positionX, int positionY, int playerCapacity, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, playerCapacity, snowLayerCount, uniqueID);
        if(rtSnowImage == null || rtIceImage == null) {
            loadImages();
        }
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

    @Override
    public void Draw(JPanel jp) {
        if (tileHeight == -1 || tileWidth == -1) {
            calculateTileDimensions();
        }

        JPanel pane = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(snowLayerCount == 0) {
                    g.drawImage(rtIceImage, 0, 0, tileHeight, tileWidth, null);

                    if (item != null) {
                        g.drawImage(item.image, 0, 0, null);
                    }
                }
                else {
                    g.drawImage(rtSnowImage, 0, 0, tileHeight, tileWidth, null);
                }

                int playerScaleX, playerScaleY;
                if(!players.isEmpty()) {
                    switch (players.size()) {
                        case 5:
                            playerScaleX = playerScaleY = 25;
                            break;
                        case 4:
                            playerScaleX = playerScaleY = 32;
                            break;
                        case 3:
                            playerScaleX = playerScaleY = 40;
                            break;
                        default:
                            playerScaleX = playerScaleY = 64;
                            break;
                    }

                    int playerIndex = 0;
                    for (Player p : players) {
                        int playerPositionX = playerIndex * playerScaleX;
                        int playerPositionY = (tileHeight / 2) - (playerScaleY / 2); // center vertically
                        g.drawImage(p.image, playerPositionX, playerPositionY, playerScaleX, playerScaleY, null);
                        playerIndex++;
                    }
                }
            }
        };

        jp.add(pane);
    }

    public void loadImages()
    {
        try {
            rtSnowImage = ImageIO.read(new File("src/gui/icons/snow.png"));
            rtIceImage = ImageIO.read(new File("src/gui/icons/ice.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}