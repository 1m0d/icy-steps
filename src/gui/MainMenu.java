package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{
    private MainFrame mainFrame;

    public MainMenu(MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
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
        add(outerPanel, BorderLayout.NORTH);
        add(innerPanel, BorderLayout.CENTER);

        this.validate();

        // action listeners
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainMenu.this.mainFrame.changePanel(new GameView());
            }
        });

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("options button event");
                MainMenu.this.mainFrame.changePanel(new OptionsView(MainMenu.this.mainFrame));
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
