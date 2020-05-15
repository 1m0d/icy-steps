package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int FrameWidth = 800;
    public static int FrameHeight = 600;
    public MainFrame(String title) throws HeadlessException {
        super(title);
        pack();
        setSize(FrameWidth, FrameHeight);
        setLocationRelativeTo(null);
        changePanel(new MenuView(this));
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
