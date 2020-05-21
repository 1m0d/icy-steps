package gui;
import modules.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *a játék nézete
 */
public class GameView {
    private static GameController gameController = GameController.getInstance();
    private static GameView gameView;
    private static ToolbarView toolbarView;
    private static JPanel mainPanel;
    /**
     *képek
     */
    private static BufferedImage snowImage;
    private static BufferedImage iceImage;
    private static BufferedImage iglooImage;
    private static BufferedImage bearImage;
    private static BufferedImage waterImage;
    private static BufferedImage campImage;

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

    /**
     *a játék grafikájának inicializálása
     */
    private static void initialize() {
        try {
            snowImage = ImageIO.read(new File("src/gui/icons/snow.png"));
            iceImage = ImageIO.read(new File("src/gui/icons/ice.png"));
            iglooImage = ImageIO.read(new File("src/gui/icons/igloo.png"));
            bearImage = ImageIO.read(new File("src/gui/icons/bear.png"));
            waterImage = ImageIO.read(new File("src/gui/icons/water.png"));
            campImage = ImageIO.read(new File("src/gui/icons/camp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tile.calculateTileDimensions();

        mainPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Tile tile : gameController.getMap().getAllTiles() ) {
                    drawTile(g, tile);
                }
            }
        };

        GridLayout gridLayout = new GridLayout(gameController.getMap().getRowCount(), gameController.getMap().getColumnCount());
        mainPanel.setLayout(gridLayout);

        toolbarView = ToolbarView.getInstance();
    }

    /**
     *a mezők kirajzolása
     */
    private static void drawTile(Graphics g, Tile tile) {
        int tileHeight = Tile.getTileHeight();
        int tileWidth = Tile.getTileWidth();

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (tile instanceof RegularTile) {
                    if (tile.getSnowLayerCount() == 0) {
                        g.drawImage(iceImage, 0, 0, tileHeight, tileWidth, null);

                        Item item = ((RegularTile)tile).getItem();
                        if (item != null) {
                            if(item.getImage() == null) {
                                item.loadImages("src/gui/icons/" + item.toString() + ".png");
                            }
                            g.drawImage(item.getImage(), 35, 35, 50, 50, null);
                        }
                    } else {
                        g.drawImage(snowImage, 0, 0, tileHeight, tileWidth, null);
                    }

                    if (((RegularTile)tile).isIglooBuilt()) {
                        g.drawImage(iglooImage, 0, 0, tileHeight, tileWidth, null);
                    }
                    if (((RegularTile)tile).isCampBuilt()) {
                        g.drawImage(campImage, 0, 0, tileHeight, tileWidth, null);
                    }


                } else if(tile instanceof HoleTile){
                    if (tile.getSnowLayerCount() == 0) {
                        g.drawImage(waterImage, 0, 0, tileHeight, tileWidth, null);
                    } else {
                        g.drawImage(snowImage, 0, 0, tileHeight, tileWidth, null);
                    }
                }

                if (tile.isScientistChecked()) {
                    g.drawString(Integer.toString(tile.getPlayerCapacity()), tileHeight - 20, tileWidth - 50);
                }
                g.drawString(Integer.toString(tile.getSnowLayerCount()), tileHeight - 20, tileWidth - 20);


                if (tile.checkBear()) {
                    g.drawImage(bearImage, 0, 0, tileHeight, tileWidth, null);
                }

                drawPlayers(g, tile.getPlayers(), tileHeight);

            }
        };
        mainPanel.add(pane);
    }

    /**
     *kirajzolja a játékosokat a pályára
     */
    private static void drawPlayers(Graphics g, ArrayList<Player> players, int tileHeight) {
        int playerScaleX, playerScaleY;
        if (!players.isEmpty()) {
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
            for (Player player : players) {
                int playerPositionX = playerIndex * playerScaleX;
                int playerPositionY = (tileHeight / 2) - (playerScaleY / 2); // center vertically
                g.drawImage(player.image, playerPositionX, playerPositionY, playerScaleX, playerScaleY, null);
                if (player.isActivePlayer()) {
                    // draw rectangle to show active player
                    g.setColor(Color.RED);
                    g.fillRect(playerPositionX, playerPositionY, 10, 10);
                }
                playerIndex++;
            }

        }
    }

    public void gameOver() {
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

        Timer exitTimer = new Timer(2500, e -> {
            System.exit(0);
        });
        exitTimer.start();
    }
}
