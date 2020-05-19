package gui;
import modules.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameView extends JPanel {

    GameController model = GameController.getInstance();

    private static int nOfRows = 4;
    private static int nOfColumns = 4;

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        model.getMap().Draw(this);
    }

    private void initializeToolbar(){
        JFrame frame = new JFrame("Navigate");
        JButton stepButton, passButton, useItemButton, clearSnowButton,pickUpItemButton, useAbilityButton;
        JComboBox stepDirCB, useAbilityCB;
        stepButton = new JButton("Step");
        stepDirCB = new JComboBox();
        stepDirCB.addItem("up");
        stepDirCB.addItem("up and right"); //HEXAGON
        stepDirCB.addItem("down and right");
        stepDirCB.addItem("down");
        stepDirCB.addItem("down and left");
        stepDirCB.addItem("up and left");
        passButton = new JButton("Pass");
        useItemButton = new JButton("Use Item");
        clearSnowButton = new JButton("Clear Snow");
        pickUpItemButton = new JButton("Pick Up Item");
        useAbilityButton = new JButton("Use Ability");
        Integer[] ids = {0, 1, 2, 3, 4};
        useAbilityCB = new JComboBox(ids);

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
        frame.add(useItemButton);
        frame.setLayout(new FlowLayout());
        frame.setSize(300,300);
        frame.setVisible(true);
    }


    public GameView() {
        super();
        JFrame frame = new JFrame();
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        frame.add(pane1, BorderLayout.WEST);
        frame.add(pane2, BorderLayout.EAST);
        GridLayout gridLayout = new GridLayout(nOfRows, nOfColumns);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        setLayout(gridLayout);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        initializeToolbar();
    }

}

