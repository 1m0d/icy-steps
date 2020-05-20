package modules;

import javax.swing.*;
import java.awt.*;

public class HoleTile extends Tile {

    public HoleTile(int positionX, int positionY, int snowLayerCount, int uniqueID) {
        super(positionX, positionY, 0, snowLayerCount, uniqueID);
        super.loadImages("src/gui/icons/water.png");
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
            GameController.getInstance().lose();
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
                g.drawImage(image,0,0, getWidth(), getHeight(), this);
                for(Player p: players)
                {
                    g.drawImage(p.image,getWidth()/4,0,null);

                }
            }
        };
        jp.add(pane);

    }


}