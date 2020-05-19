package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static final int FrameWidth = 800;
    public static final int FrameHeight = 600;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        pack();
        setSize(FrameWidth, FrameHeight);
        setResizable(false);
        setLocationRelativeTo(null); // centers frame
        changePanel(new MainMenu(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
        setVisible(true);
    }
}
