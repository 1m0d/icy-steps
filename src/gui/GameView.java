package gui;
import gui.controllers.GameViewController;
import modules.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private static MainFrame mainFrame = MainFrame.getInstance();

    public static GameView getInstance() {
        if (gameView == null) {
            gameView = new GameView();
            initialize();
        }
        return gameView;
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

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

    public void gameOver() {
        //mainFrame.changePanel(MainMenu.getInstance().getPanel());

        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        JLabel jlabel = new JLabel();
        if (gameController.isGameOver()) {
            if (gameController.isPlayersWon()) {
                jlabel.setText("YOU WON!");
            } else {
                jlabel.setText("YOU LOST!");
            }
        }
        jlabel.setFont(new Font("Verdana",1,55));
        panel.add(jlabel);
        panel.setBorder(new LineBorder(Color.BLACK));
        frame.add(panel, new GridBagConstraints());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        }
    }



