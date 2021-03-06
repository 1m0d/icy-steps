package gui;

import modules.GameController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *a beállítások menüje
 */
public class OptionsMenu {
    private static OptionsMenu optionsView;
    private static MainFrame mainFrame = MainFrame.getInstance();
    private static JPanel panel = new JPanel(new BorderLayout());
    private static GameController gameController = GameController.getInstance();

    public static OptionsMenu getInstance() {
        if (optionsView == null) {
            optionsView = new OptionsMenu();
            initialize();
        }
        return optionsView;
    }

    /**
     *a beállítások menüjének inicializálása
     */
    private static void initialize() {
        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel(new GridLayout(2,2));
        JPanel thirdPanel = new JPanel();

        JLabel titleLabel = new JLabel("Options", JLabel.CENTER);
        JLabel nOfPlayersLabel = new JLabel("Players:", JLabel.CENTER);
        JLabel chooseMapLabel = new JLabel("Map", JLabel.CENTER);
        SpinnerModel model = new SpinnerNumberModel(3, 3, 5, 1);
        JSpinner nOfPlayersSpinner = new JSpinner(model);
        JButton mapBtn = new JButton("Choose Map");

        JButton cancelBtn = new JButton("Cancel");
        JButton okBtn = new JButton("Ok");

        firstPanel.add(titleLabel);
        firstPanel.setPreferredSize(new Dimension(100,100));

        secondPanel.add(nOfPlayersLabel);
        secondPanel.add(nOfPlayersSpinner);
        secondPanel.add(chooseMapLabel);
        secondPanel.add(mapBtn);

        thirdPanel.add(cancelBtn);
        thirdPanel.add(okBtn);
        thirdPanel.setPreferredSize(new Dimension(400,400));

        panel.add(firstPanel, BorderLayout.NORTH);
        panel.add(secondPanel, BorderLayout.CENTER);
        panel.add(thirdPanel, BorderLayout.SOUTH);

        /**
         *action listenerek
         */
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.changePanel(MainMenu.getInstance().getPanel());
            }
        });

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.changePanel(MainMenu.getInstance().getPanel());
            }
        });

        mapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setCurrentDirectory(new File("maps"));
                int returnValue = fc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile = fc.getSelectedFile();
                    try {
                        GameController.getInstance().loadMap(selectedFile.getAbsolutePath());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(fc.getSelectedFile().getName().startsWith("3")) {
                    model.setValue(3); }
                else if(fc.getSelectedFile().getName().startsWith("4")) {
                    model.setValue(4);}
                else if(fc.getSelectedFile().getName().startsWith("5")) {
                    model.setValue(5);}
            }
        });

        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                try {
                    gameController.loadMap(String.format("maps/%d-players", model.getValue()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){ return panel; }
}