package gui;
import modules.GameController;
import modules.Interpreter;
import modules.Player;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GameView extends JPanel {
    GameController gameController = GameController.getInstance();

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

    private void initializeToolbar(){
        JFrame frame = new JFrame("Navigate");
        JButton stepButton, passButton, useItemButton, clearSnowButton,pickUpItemButton, useAbilityButton;
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
        Integer[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}; //ezt nem igy kellene probably
        useAbilityCB = new JComboBox(ids);

        ImageIcon cImage =  new ImageIcon("src/gui/icons/camp.png");
        JButton campButton = new JButton(resizeIcon(cImage));
        ImageIcon dsImage =  new ImageIcon("src/gui/icons/divingsuit.gif");
        JButton divingsuitButton = new JButton(resizeIcon(dsImage));
        ImageIcon fImage =  new ImageIcon("src/gui/icons/food.jpg");
        JButton foodButton = new JButton(resizeIcon(fImage));
        ImageIcon fsImage =  new ImageIcon("src/gui/icons/fragileshovel.png");
        JButton fshovelButton = new JButton(resizeIcon(fsImage));
        ImageIcon rImage =  new ImageIcon("src/gui/icons/rope.png");
        JButton ropeButton = new JButton(resizeIcon(rImage));
        ImageIcon sImage =  new ImageIcon("src/gui/icons/shovel.gif");
        JButton shovelButton = new JButton(resizeIcon(sImage));
        ImageIcon w1Image =  new ImageIcon("src/gui/icons/winningitem1.png");
        JButton w1Button = new JButton(resizeIcon(w1Image));
        ImageIcon w2Image =  new ImageIcon("src/gui/icons/winningitem2.png");
        JButton w2Button = new JButton(resizeIcon(w2Image));
        ImageIcon w3Image =  new ImageIcon("src/gui/icons/winningitem3.png");
        JButton w3Button = new JButton(resizeIcon(w3Image));


        //Action listeners
        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.getInstance().getCurrentPlayer().pass();
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
                gameController.getCurrentPlayer().clearSnow();
            }
        });
        
        pickUpItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.getCurrentPlayer().pickUpItem();
            }
        });

        useAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.getCurrentPlayer().useAbility( gameController.getInstance().getCurrentPlayer().getPosition());
                //TODO Scientist nem tud masik mezot megvizsgalni, csak amin eppen all (Eskimo miatt).
            }
        });

        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"food"});
            }
        });

        campButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"camp"});
            }
        });

        divingsuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"diving-suit"});
            }
        });

        shovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"shovel"});
            }
        });

        fshovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
            }
        });

        ropeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"rope", String.valueOf(gameController.getInstance().getCurrentPlayer().getPosition().getUniqueID())});
            }
        });

        w1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"winning-item"});
            }
        });

        w2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"winning-item"});
            }
        });

        w3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"winning-item"});
            }
        });


        frame.add(stepButton);
        frame.add(stepDirCB);
        frame.add(passButton);
        frame.add(useAbilityButton);
        frame.add(useAbilityCB);
        frame.add(clearSnowButton);
        frame.add(pickUpItemButton);
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
        frame.setSize(250,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public GameView() {
        super();
        GridLayout gridLayout = new GridLayout(gameController.getMap().getRowCount(), gameController.getMap().getColumnCount());
        setLayout(gridLayout);
        initializeToolbar();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

