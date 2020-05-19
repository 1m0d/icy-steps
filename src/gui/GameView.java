package gui;
import modules.GameController;
import modules.Player;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameView extends JPanel {

    GameController model = GameController.getInstance();

    private static int nOfRows = 4;
    private static int nOfColumns = 4;

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        model.getMap().Draw(this);
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
        useItemButton = new JButton("Use Item");
        clearSnowButton = new JButton("Clear Snow");
        pickUpItemButton = new JButton("Pick Up Item");
        useAbilityButton = new JButton("Use Ability");
        Integer[] ids = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}; //ezt nem igy kellene probably
        useAbilityCB = new JComboBox(ids);

        ImageIcon cImage =  new ImageIcon("src/gui/icons/camp.png");
        JButton cButton = new JButton(resizeIcon(cImage));
        ImageIcon dsImage =  new ImageIcon("src/gui/icons/divingsuit.gif");
        JButton dsButton = new JButton(resizeIcon(dsImage));
        ImageIcon fImage =  new ImageIcon("src/gui/icons/food.jpg");
        JButton foodButton = new JButton(resizeIcon(fImage));
        ImageIcon fsImage =  new ImageIcon("src/gui/icons/fragileshovel.png");
        JButton fstButton = new JButton(resizeIcon(fsImage));
        ImageIcon rImage =  new ImageIcon("src/gui/icons/rope.png");
        JButton rButton = new JButton(resizeIcon(rImage));
        ImageIcon sImage =  new ImageIcon("src/gui/icons/shovel.gif");
        JButton sButton = new JButton(resizeIcon(sImage));
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
                GameController.getInstance().endPlayerTurn();
            }
        });

        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  GameModel.getInstance().getCurrentPlayer().step(...); //HEXAGON csempek kellenek
            }
        });

        clearSnowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.getInstance().getCurrentPlayer().clearSnow();
            }
        });

        useItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   GameModel.getInstance().getCurrentPlayer().useItem(.. , GameModel.getInstance().getCurrentPlayer().getPosition());
            }
        });

        pickUpItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController.getInstance().getCurrentPlayer().pickUpItem();
            }
        });

        useAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           GameController.getInstance().getCurrentPlayer().useAbility( GameController.getInstance().getCurrentPlayer().getPosition());
                //Scientist egyelore nem tud masik mezot megvizsgalni, csak amin eppen all.
                // pont ugyanazert, amiert meg a lepes sincs kesz.
            }
        });


        frame.add(stepButton);
        frame.add(stepDirCB);
        frame.add(passButton);
        frame.add(useAbilityButton);
        frame.add(useAbilityCB);
        frame.add(clearSnowButton);
        frame.add(pickUpItemButton);

        frame.add(cButton);
        frame.add(dsButton);
        frame.add(foodButton);
        frame.add(fstButton);
        frame.add(rButton);
        frame.add(sButton);
        frame.add(w1Button);
        frame.add(w2Button);
        frame.add(w3Button);


        frame.setLayout(new FlowLayout());
        frame.setSize(250,500);
        frame.setVisible(true);
    }


    public GameView() {
        super();
        GridLayout gridLayout = new GridLayout(nOfRows, nOfColumns);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        setLayout(gridLayout);
        initializeToolbar();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }

}

