package gui;
import gui.controllers.GameViewController;
import modules.*;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView {
    private static GameController gameController = GameController.getInstance();
    private static GameViewController gameViewController;
    private static GameView gameView;
    private static ToolbarView toolbarView;
    private static JPanel mainPanel;

    public static GameView getInstance() {
        if (gameView == null) {
            gameView = new GameView();
            initialize();
        }
        return gameView;
    }

    public static JPanel getMainPanel() { return mainPanel; }

    private static void initialize() {
        mainPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                doDrawing(g);
            }

            private void doDrawing(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                gameController.getMap().Draw(mainPanel);
            }
        };

        GridLayout gridLayout = new GridLayout(gameController.getMap().getRowCount(), gameController.getMap().getColumnCount());
        mainPanel.setLayout(gridLayout);

        gameViewController = new GameViewController();
        toolbarView = ToolbarView.getInstance();
    }
}
