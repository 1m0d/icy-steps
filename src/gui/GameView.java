package gui;
import modules.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameView extends JPanel {
    static GameController gameController = GameController.getInstance();
    String itemType;
    static MainFrame mainFrame;

    static GridLayout gridLayout;
    public static GameView Instance;


    Interpreter interpreter = new Interpreter();
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        gameController.getMap().Draw(this);
    }

    private static Icon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void initializeToolbar() {
            JFrame frame = new JFrame("Navigate");
            JButton stepButton, passButton, useItemButton, clearSnowButton, pickUpItemButton, useAbilityButton;
            JComboBox stepDirCB, useAbilityCB;
            stepButton = new JButton("Step");
            stepDirCB = new JComboBox();
            stepDirCB.addItem("up");
            stepDirCB.addItem("right");
            stepDirCB.addItem("down");
            stepDirCB.addItem("left");
            passButton = new JButton("Pass");
            clearSnowButton = new JButton("Clear Snow");
            pickUpItemButton = new JButton("Pick Up Item");
            useAbilityButton = new JButton("Use Ability");
            String[] ids = {"up", "right", "down", "left"};
            useAbilityCB = new JComboBox(ids);
            useItemButton = new JButton("Use Item");
            JLabel playerStatus = new JLabel(gameController.getCurrentPlayer().toString());

            ImageIcon cImage = new ImageIcon("src/gui/icons/camp.png");
            JButton campButton = new JButton(resizeIcon(cImage));
            ImageIcon dsImage = new ImageIcon("src/gui/icons/divingsuit.gif");
            JButton divingsuitButton = new JButton(resizeIcon(dsImage));
            ImageIcon fImage = new ImageIcon("src/gui/icons/food.jpg");
            JButton foodButton = new JButton(resizeIcon(fImage));
            ImageIcon fsImage = new ImageIcon("src/gui/icons/fragileshovel.png");
            JButton fshovelButton = new JButton(resizeIcon(fsImage));
            ImageIcon rImage = new ImageIcon("src/gui/icons/rope.png");
            JButton ropeButton = new JButton(resizeIcon(rImage));
            ImageIcon sImage = new ImageIcon("src/gui/icons/shovel.gif");
            JButton shovelButton = new JButton(resizeIcon(sImage));
            ImageIcon w1Image = new ImageIcon("src/gui/icons/winningitem1.png");
            JButton w1Button = new JButton(resizeIcon(w1Image));
            ImageIcon w2Image = new ImageIcon("src/gui/icons/winningitem2.png");
            JButton w2Button = new JButton(resizeIcon(w2Image));
            ImageIcon w3Image = new ImageIcon("src/gui/icons/winningitem3.png");
            JButton w3Button = new JButton(resizeIcon(w3Image));

            //ArrayList<Item> items = gameController.getCurrentPlayer().getItems();


            //Action listeners
            passButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("player-pass", null);
                    repaint();
                }
            });

            stepButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("step", new String[]{stepDirCB.getSelectedItem().toString()});
                    repaint();
                }
            });

            clearSnowButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("clear-snow", null);
                    repaint();
                }
            });

            pickUpItemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("pick-up-item", null);
                    repaint();
                }
            });

            useAbilityButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Player currentPlayer = gameController.getCurrentPlayer();
                    if (currentPlayer instanceof Scientist) {
                        interpreter.executeCommand("use-scientist-ability", new String[]{useAbilityCB.getSelectedItem().toString()});
                    } else {
                        interpreter.executeCommand("use-eskimo-ability", null);
                    }
                    repaint();
                }
            });


            foodButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"food"});
                    //repaint();
                    itemType = "food";

                }
            });

            campButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"camp"});
                    //repaint();
                    itemType = "camp";
                }

            });

            divingsuitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"diving-suit"});
                    //repaint();
                    itemType = "diving-suit";
                }
            });

            shovelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"shovel"});
                    //repaint();
                    itemType = "shovel";
                }
            });

            fshovelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
                    //repaint();
                    itemType = "fragile-shovel";
                }
            });

            ropeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //interpreter.executeCommand("use-item", new String[]{"rope", String.valueOf(gameController.getInstance().getCurrentPlayer().getPosition().getUniqueID())});
                    //repaint();
                    itemType = "rope";
                }
            });

            w1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //interpreter.executeCommand("use-item", new String[]{"winning-item"});
                    //repaint();
                    itemType = "winning-item";
                }
            });

            w2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("use-item", new String[]{"winning-item"});
                    repaint();
                    itemType = "winning-item";
                }
            });

            w3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interpreter.executeCommand("use-item", new String[]{"winning-item"});
                    repaint();
                    itemType = "winning-item";
                }
            });

            useItemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    interpreter.executeCommand("use-item", new String[]{itemType});
                    repaint();
                }
            });

            frame.add(playerStatus);
            frame.add(stepButton);
            frame.add(stepDirCB);
            frame.add(passButton);
            frame.add(useAbilityButton);
            frame.add(useAbilityCB);
            frame.add(clearSnowButton);
            frame.add(pickUpItemButton);
            frame.add(useItemButton);
            frame.add(campButton);
            frame.add(divingsuitButton);
            frame.add(foodButton);
            frame.add(fshovelButton);
            frame.add(ropeButton);
            frame.add(shovelButton);
            frame.add(w1Button);
            frame.add(w2Button);
            frame.add(w3Button);

            frame.setLayout(new FlowLayout());
            frame.setSize(250, 500);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public GameView() {
        super();
        gridLayout = new GridLayout(gameController.getMap().getRowCount(), gameController.getMap().getColumnCount());
        setLayout(gridLayout);
            initializeToolbar();
        Instance = this;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public void gameOver() {
        //frame.dispose();
        mainFrame.changePanel(MainMenu.getInstance().getPanel());
    }
}

