package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class MenuView extends JPanel
{
    private MainFrame myFrame;

    public MenuView(MainFrame mainFrame) {
        super();
        myFrame = mainFrame;
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
                myFrame.changePanel(new GameView());

            }
        });
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("options button event");
                myFrame.changePanel(new OptionsView(myFrame));
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
