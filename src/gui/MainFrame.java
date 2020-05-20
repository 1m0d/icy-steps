package gui;

import modules.GameController;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static MainFrame mainFrame;
    private static JFrame frame;
    private static final int FrameWidth = 800;
    private static final int FrameHeight = 800;

    public static MainFrame getInstance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
            initialize();
        }
        return mainFrame;
    }

    private static void initialize() throws HeadlessException {
        frame = new JFrame();
        frame.pack();
        frame.setSize(FrameWidth, FrameHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // centers frame
        changePanel(MainMenu.getInstance().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void changePanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().doLayout();
        frame.update(frame.getGraphics());
        frame.setVisible(true);
    }

    public static int getFrameWidth() { return FrameWidth; }
    public static int getFrameHeight() { return FrameHeight; }
}
