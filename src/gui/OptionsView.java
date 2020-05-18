package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class OptionsView extends JPanel {

    MainFrame myFrame;
    public OptionsView(MainFrame mainFrame) {
        super(new BorderLayout());
        myFrame = mainFrame;
        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel(new GridLayout(2,2));
        JPanel thirdPanel = new JPanel();

        JLabel titleLabel = new JLabel("Options", JLabel.CENTER);
        JLabel nOfPlayersLabel = new JLabel("Players:", JLabel.CENTER);
        JLabel chooseMapLabel = new JLabel("Map", JLabel.CENTER);
        SpinnerModel model =
                new SpinnerNumberModel(3,
                        3,
                        5,
                1);                //step
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

        add(firstPanel, BorderLayout.NORTH);
        add(secondPanel, BorderLayout.CENTER);
        add(thirdPanel, BorderLayout.SOUTH);

        //action listeners
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myFrame.changePanel(new MenuView(myFrame));
            }
        });

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myFrame.changePanel(new MenuView(myFrame));
            }
        });

        mapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                }

            }
        });
    }
}