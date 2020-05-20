package gui;
import gui.controllers.GameViewController;
import modules.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView {
    private static GameController gameController = GameController.getInstance();
    private static GameViewController gameViewController;
    private static GameView gameView;
    private static JPanel mainPanel;

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

    Interpreter interpreter = new Interpreter();
    private String itemType;


    private static Icon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void initializeToolbar(){
        JFrame toolbarFrame = new JFrame();
        JPanel toolbarPanel = new JPanel();

        toolbarFrame.add(toolbarPanel);
        toolbarFrame.setSize(250,500);
        toolbarFrame.setVisible(true);
        toolbarFrame.setResizable(false);
        toolbarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        toolbarPanel.setLayout(new FlowLayout());

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

        ImageIcon cImage =  new ImageIcon("src/gui/icons/camp.png");
        JButton campButton = new JButton(resizeIcon(cImage));
        ImageIcon dsImage =  new ImageIcon("src/gui/icons/diving-suit.png");
        JButton divingsuitButton = new JButton(resizeIcon(dsImage));
        ImageIcon fImage =  new ImageIcon("src/gui/icons/food.png");
        JButton foodButton = new JButton(resizeIcon(fImage));
        ImageIcon fsImage =  new ImageIcon("src/gui/icons/fragile-shovel.png");
        JButton fshovelButton = new JButton(resizeIcon(fsImage));
        ImageIcon rImage =  new ImageIcon("src/gui/icons/rope.png");
        JButton ropeButton = new JButton(resizeIcon(rImage));
        ImageIcon sImage =  new ImageIcon("src/gui/icons/shovel.png");
        JButton shovelButton = new JButton(resizeIcon(sImage));
        ImageIcon w1Image =  new ImageIcon("src/gui/icons/winning-item.png");
        JButton w1Button = new JButton(resizeIcon(w1Image));
        ImageIcon w2Image =  new ImageIcon("src/gui/icons/winningitem2.png");
        JButton w2Button = new JButton(resizeIcon(w2Image));
        ImageIcon w3Image =  new ImageIcon("src/gui/icons/winningitem3.png");
        JButton w3Button = new JButton(resizeIcon(w3Image));

        toolbarPanel.add(playerStatus);
        toolbarPanel.add(stepButton);
        toolbarPanel.add(stepDirCB);
        toolbarPanel.add(passButton);
        toolbarPanel.add(useAbilityButton);
        toolbarPanel.add(useAbilityCB);
        toolbarPanel.add(clearSnowButton);
        toolbarPanel.add(pickUpItemButton);
        toolbarPanel.add(useItemButton);
        toolbarPanel.add(campButton);
        toolbarPanel.add(divingsuitButton);
        toolbarPanel.add(foodButton);
        toolbarPanel.add(fshovelButton);
        toolbarPanel.add(ropeButton);
        toolbarPanel.add(shovelButton);
        toolbarPanel.add(w1Button);
        toolbarPanel.add(w2Button);
        toolbarPanel.add(w3Button);

        //Action listeners

        MouseAdapter mAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mainPanel.repaint();
                playerStatus.setText(gameController.getCurrentPlayer().toString());
                
                //System.out.println("repaint call");
            }
        };
        for (Component c: toolbarPanel.getComponents())
        {
            c.addMouseListener(mAdapter);
        }

        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("player-pass", null);
            }
        });
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("step", new String[]{stepDirCB.getSelectedItem().toString()});
            }
        });

        clearSnowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("clear-snow", null);
            }
        });
        
        pickUpItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("pick-up-item", null);
            }
        });

        useAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer = gameController.getCurrentPlayer();
                if (currentPlayer instanceof Scientist)
                {
                    interpreter.executeCommand("use-scientist-ability", new String[]{useAbilityCB.getSelectedItem().toString()});
                }
                else
                {
                    interpreter.executeCommand("use-eskimo-ability", null);
                }
            }
        });

        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"food"});
                itemType = "food";

            }
        });

        campButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"camp"});
                itemType ="camp";
            }

        });

        divingsuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"diving-suit"});
                itemType = "diving-suit";
            }
        });

        shovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"shovel"});
                itemType = "shovel";
            }
        });

        fshovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
                itemType ="fragile-shovel";
            }
        });

        ropeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"rope", String.valueOf(gameController.getInstance().getCurrentPlayer().getPosition().getUniqueID())});
                itemType = "rope";
            }
        });

        w1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"winning-item"});
                itemType ="winning-item";
            }
        });

        w2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"winning-item"});
                itemType ="winning-item";
            }
        });

        w3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //interpreter.executeCommand("use-item", new String[]{"winning-item"});
                itemType ="winning-item";
            }
        });

        useItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                interpreter.executeCommand("use-item", new String[]{itemType});
            }
        });

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
    }
}
