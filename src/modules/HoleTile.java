package modules;

import gui.GameView;
import gui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class HoleTile extends Tile {

    private BufferedImage htImage;
    public HoleTile(int positionX, int positionY, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, 0, snowLayerCount, uniqueID);
        loadImages();
    }

    public void onPlayerStep(Player p) {
        players.add(p);
        p.onHole();
    }

    public void onRope() {
        players.clear();
    }

    @Override
    public void onBearStep(){
        if(!players.isEmpty())
            GameModel.getInstance().lose();
    }

    @Override
    public void onStorm() {
        for (Player player : players ) {
            player.damage();
        }
    }


    @Override
    public void Draw(JPanel jp) {

        JPanel pane = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(htImage,0,0, getWidth(), getHeight(), this);
                for(Player p: players)
                {
                    g.drawImage(p.getImage(),getWidth()/4,0,null);

                }
            }
        };

        jp.add(pane);

    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    public void loadImages()
    {
        try {
            htImage = ImageIO.read(new File("src/gui/icons/water.jpg"));
            //htImage = htImage.getSubimage(0,0, MainFrame.FrameWidth,MainFrame.FrameHeight/)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}