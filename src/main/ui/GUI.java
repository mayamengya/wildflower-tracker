package ui;

import javax.swing.*;


// Represents the graphic user interface for Wildflower Tracker
public class GUI {
    JFrame frame = new JFrame();
    JLabel logo = new JLabel();

    // EFFECTS: initializes main menu and data
    public GUI() {
        initializeLogo();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Wildflower Tracker");
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setResizable(false);


    }

    // MODIFIES: this
    // EFFECTS: initalizes main menu image
    public void initializeLogo() {
        ImageIcon logoImage = new ImageIcon("wildflower-tracker.png");
        logo.setIcon(logoImage);
    }

}
