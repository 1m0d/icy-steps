package gui;
import modules.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainMenu
{
    private static MainMenu mainMenu;
    private static JPanel panel = new JPanel();
    private static MainFrame mainFrame = MainFrame.getInstance();

    public static MainMenu getInstance() {
        if (mainMenu == null) {
            mainMenu = new MainMenu();
            initialize();
        }
        return mainMenu;
    }

    private static void initialize(){
        panel.setLayout(new BorderLayout());
        JPanel innerPanel = new JPanel();
        JPanel outerPanel = new JPanel(new BorderLayout());

        JButton startGame = new JButton("Start Game");
        JButton options = new JButton("Options");
        JButton exit = new JButton("Exit");
        JLabel titleLabel = new JLabel("Icy Steps", SwingConstants.CENTER);

        outerPanel.add(titleLabel);
        outerPanel.setPreferredSize(new Dimension(150,150));
        innerPanel.add(startGame);
        innerPanel.add(options);
        innerPanel.add(exit);
        panel.add(outerPanel, BorderLayout.NORTH);
        panel.add(innerPanel, BorderLayout.CENTER);

        panel.validate();

        // action listeners
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (GameController.getInstance().getMap() == null)
                {
                    try {
                        GameController.getInstance().loadMap("maps/map");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                mainFrame.changePanel(new GameView());

            }
        });

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.changePanel(OptionsMenu.getInstance().getPanel());
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public JPanel getPanel(){ return panel; }
}
