package gui;
import modules.GameModel;
import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    GameModel model = GameModel.getInstance();

    private static int nOfRows = 4;
    private static int nOfColumns = 4;

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        model.getMap().Draw(this);
    }

    public GameView() {
        super();
        GridLayout gridLayout = new GridLayout(nOfRows, nOfColumns);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        setLayout(gridLayout);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

}

