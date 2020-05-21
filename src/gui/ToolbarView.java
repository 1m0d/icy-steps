package gui;

import gui.controllers.ToolBarController;
import modules.GameController;
import modules.Interpreter;
import modules.Player;
import modules.Scientist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolbarView {
    private static ToolbarView toolbarview;
    private static ToolBarController toolBarController;
    private static GameView gameView;
    private static GameController gameController;
    private static JPanel toolbarPanel;
    private static JLabel playerStatus = new JLabel();

    public static ToolbarView getInstance(){
        if(toolbarview == null){
            toolbarview = new ToolbarView();
            initialize();
        }
        return toolbarview;
    }

    private static void initialize(){
        toolBarController = new ToolBarController();
        gameView = GameView.getInstance();
        gameController = GameController.getInstance();
        JFrame toolbarFrame = new JFrame();
        toolbarPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                playerStatus.setText(gameController.getCurrentPlayer().toString());
            }
        };

        toolbarFrame.add(toolbarPanel);
        toolbarFrame.setSize(250,500);
        toolbarFrame.setVisible(true);
        toolbarFrame.setResizable(false);
        toolbarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        toolbarPanel.setLayout(new FlowLayout());

        JButton stepButton, passButton, clearSnowButton, pickUpItemButton, useAbilityButton, useItemButton;
        JComboBox stepDirCB, useAbilityCB, ropeCB;;
        stepButton = new JButton("Step");
        passButton = new JButton("Pass");
        clearSnowButton = new JButton("Clear Snow");
        pickUpItemButton = new JButton("Pick Up Item");
        useAbilityButton = new JButton("Use Ability");
        useItemButton = new JButton("Use Item");
        String[] dirs = {"up", "right", "down", "left"};
        stepDirCB = new JComboBox(dirs);
        ropeCB = new JComboBox(dirs);
        ropeCB.setVisible(false);
        useAbilityCB = new JComboBox(dirs);
        JLabel playerStatus = new JLabel(gameController.getCurrentPlayer().toString());

        ImageIcon cImage =  new ImageIcon("src/gui/icons/camp.png");
        JButton campButton = new JButton(resizeIcon(cImage));
        ImageIcon dsImage =  new ImageIcon("src/gui/icons/diving-suit.png");
        JButton divingsuitButton = new JButton(resizeIcon(dsImage));
        ImageIcon fImage =  new ImageIcon("src/gui/icons/food.png");
        JButton foodButton = new JButton(resizeIcon(fImage));
        ImageIcon fsImage =  new ImageIcon("src/gui/icons/fragile-shovel.png");
        JButton fShovelButton = new JButton(resizeIcon(fsImage));
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
        toolbarPanel.add(useItemButton);
        toolbarPanel.add(clearSnowButton);
        toolbarPanel.add(pickUpItemButton);
        toolbarPanel.add(campButton);
        toolbarPanel.add(divingsuitButton);
        toolbarPanel.add(foodButton);
        toolbarPanel.add(fShovelButton);
        toolbarPanel.add(ropeButton);
        toolbarPanel.add(shovelButton);
        toolbarPanel.add(w1Button);
        toolbarPanel.add(w2Button);
        toolbarPanel.add(w3Button);
        toolbarPanel.add(ropeCB);

        //Action listeners
        MouseAdapter mAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                toolBarController.toolbarButtonPressed(useAbilityCB, ropeCB);
            }
        };

        for (Component c: toolbarPanel.getComponents()) {
            c.addMouseListener(mAdapter);
        }

        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.passButtonPressed();
            }
        });

        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.stepButtonPressed(stepDirCB);
            }
        });

        clearSnowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.clearSnowButtonPressed();
            }
        });

        pickUpItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.pickUpItemButtonPressed();
            }
        });

        useAbilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.useAbilityButtonPressed(useAbilityCB);
            }
        });

        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.foodButtonPressed();
            }
        });

        campButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.campButtonPressed();
            }

        });

        divingsuitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.divingsuitButtonPressed();
            }
        });

        shovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.shovelButtonPressed();
            }
        });

        fShovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.fShovelButtonPressed();
            }
        });

        ropeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.ropeButtonPressed(ropeCB);
            }
        });

        w1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.winItemButtonPressed();
            }
        });

        w2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.winItemButtonPressed();
            }
        });

        w3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBarController.winItemButtonPressed();
            }
        });

        useItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                toolBarController.useItemButtonPressed(ropeCB);
            }
        });
    }

    public JPanel getToolbarPanel(){ return toolbarPanel; }

    private static Icon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
