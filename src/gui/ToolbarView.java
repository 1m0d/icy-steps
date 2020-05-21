package gui;

import gui.controllers.GameViewController;
import gui.controllers.ToolBarController;
//import jdk.jshell.spi.ExecutionControl;
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
    private static Interpreter interpreter = new Interpreter();
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

        JButton stepButton, passButton, clearSnowButton, pickUpItemButton, useAbilityButton;
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

        //Action listeners
        MouseAdapter mAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                toolBarController.toolbarButtonPressed();
            }
        };

        for (Component c: toolbarPanel.getComponents()) {
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
                if (currentPlayer instanceof Scientist) {
                    interpreter.executeCommand("use-scientist-ability", new String[]{useAbilityCB.getSelectedItem().toString()});
                }
                else {
                    interpreter.executeCommand("use-eskimo-ability", null);
                }
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

        fShovelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpreter.executeCommand("use-item", new String[]{"fragile-shovel"});
            }
        });

        ropeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: should be able to choose which square to use it on
                throw new UnsupportedOperationException("Not implemented yet");
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
    }

    public JPanel getToolbarPanel(){ return toolbarPanel; }

    private static Icon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
