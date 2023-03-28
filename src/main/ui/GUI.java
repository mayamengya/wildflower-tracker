package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Represents the graphic user interface for Wildflower Tracker
public class GUI extends JFrame {
    // Aesthetic constants
    Color deepPurple = new Color(49, 26, 95);
    Color cloudBlue = new Color(191, 235, 244);
    Font font = new Font("04b_03", Font.PLAIN, 20);

    // Layout
    JPanel logoPanel = new JPanel();
    JPanel controlPanel = new JPanel();
    JFrame frame = new JFrame();
    JLabel logo = new JLabel();

    // Buttons
    JButton addWildflower = new JButton("Add");
    JButton removeWildflower = new JButton("Remove");
    JButton haveISeenThisWildflower = new JButton("Have I seen this before?");
    JButton displayTypes =  new JButton("Types");
    JButton displayLocations = new JButton("Locations");
    JButton save = new JButton("Save");
    JButton load = new JButton("Load");


    // EFFECTS: initializes main menu and data
    public GUI() {
        initializeLogo();
        initializePanels();
        initializeMainFrame();
        initializeButtons();


    }

    // MODIFIES: this
    // EFFECTS: initializes main menu logo image
    public void initializeLogo() {
        ImageIcon logoImage = new ImageIcon("wildflower-tracker.png");
        logo.setIcon(logoImage);
        logo.setSize(logoImage.getIconWidth(), logoImage.getIconHeight());
    }

    // MODIFIES: this
    // EFFECTS: initializes JPanels of main menu
    public void initializePanels() {
        controlPanel.setBackground(deepPurple);
        controlPanel.setBounds(0, 500, 700, 350);
        logoPanel.setBounds(0, 0, 700, 500);
        logoPanel.add(logo);


    }

    // MODIFIES: this
    // EFFECTS: initializes JFrame of main menu
    public void initializeMainFrame() {
        frame.setLayout(null);
        frame.setTitle("Wildflower Tracker");
        frame.setSize(700, 850);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(logoPanel);
        frame.add(controlPanel);
        controlPanel.add(addWildflower);
        controlPanel.add(removeWildflower);
        controlPanel.add(haveISeenThisWildflower);
        controlPanel.add(displayTypes);
        controlPanel.add(displayLocations);
        controlPanel.add(save);
        controlPanel.add(load);
        controlPanel.setLayout(null);

    }

    public void makeButton(JButton button, String text, int x, int y, Font f,
                           Color foreground, Color background) {
        button.setText(text);
        button.setBounds(x, y, 210, 100);
        button.setFont(f);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setVisible(true);
        button.setEnabled(true);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(new ButtonListener());

    }

    // MODIFIES: this
    // EFFECTS: initializes the main menu JButtons
    public void initializeButtons() {
        makeButton(addWildflower, "Add", 20, 10, font, deepPurple, cloudBlue);
        makeButton(removeWildflower, "Remove", 20, 120, font, deepPurple, cloudBlue);
        makeButton(haveISeenThisWildflower, "Have I seen this before?", 20, 120,
                font, deepPurple, cloudBlue);
        makeButton(displayTypes, "Types", 220, 230,
                font, deepPurple, cloudBlue);
        makeButton(displayLocations, "Locations", 230, 340,
                font, deepPurple, cloudBlue);
        makeButton(save, "Save", 340, 340,
                font, deepPurple, cloudBlue);
        makeButton(load, "Load", 340, 340,
                font, deepPurple, cloudBlue);
    }

    // Represents the listener of the buttons in the main menu of the GUI
    static class ButtonListener implements ActionListener {

        // EFFECTS: performs appropriate actions after buttons are clicked
        // Code structure below adapted from Teller App:
        // https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add")) {
                addWildflowerAction();
            } else if (e.getActionCommand().equals("Remove")) {
                removeWildflowerAction();
            } else if (e.getActionCommand().equals("Have I seen this before?")) {
                haveISeenThisWildflowerAction();
            } else if (e.getActionCommand().equals("Display")) {
                displayTypesAction();
            } else if (e.getActionCommand().equals("Location")) {
                displayLocationsAction();
            } else if (e.getActionCommand().equals("Save")) {
                saveAction();
            } else if (e.getActionCommand().equals("Load")) {
                loadAction();
            } else {
                System.out.println("That option does not exist!");
            }
        }

        private void addWildflowerAction() {
        }

        private void removeWildflowerAction() {
        }

        private void haveISeenThisWildflowerAction() {
        }

        private void displayTypesAction() {
        }

        private void displayLocationsAction() {
        }

        private void saveAction() {
        }

        private void loadAction() {
        }

    }
}
