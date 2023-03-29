package ui;

import model.Wildflower;
import model.WildflowerList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileNotFoundException;


// Represents the graphic user interface for Wildflower Tracker
public class GUI extends JFrame {
    // Aesthetic constants
    Color deepPurple = new Color(49, 26, 95);
    Color cloudBlue = new Color(191, 235, 244);
    Font font = new Font("04b_03", Font.PLAIN, 15);

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

    private static final String JSON_STORE = "./data/WildflowerList.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private final WildflowerList wildflowerList = new WildflowerList("My Wildflower List");


    // EFFECTS: initializes main menu and data
    public GUI() {
        initializeLogo();
        initializePanels();
        initializeMainFrame();
        initializeButtons();
        initializeData();
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

    public void makeButtonMiddle(JButton button, String text, int x, int y, Font f,
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
    }

    public void makeButtonMiddleTB(JButton button, String text, int x, int y, Font f,
                                   Color foreground, Color background) {
        button.setText(text);
        button.setBounds(x, y, 140, 60);
        button.setFont(f);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setVisible(true);
        button.setEnabled(true);
        button.setBorder(BorderFactory.createEtchedBorder());
    }

    public void makeButtonSides(JButton button, String text, int x, int y, Font f,
                                Color foreground, Color background) {
        button.setText(text);
        button.setBounds(x, y, 140, 60);
        button.setFont(f);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setVisible(true);
        button.setEnabled(true);
        button.setBorder(BorderFactory.createEtchedBorder());
    }

    // MODIFIES: this
    // EFFECTS: initializes the main menu JButtons
    public void initializeButtons() {
        makeButtonSides(addWildflower, "Add", 60, 35, font, deepPurple, cloudBlue);
        makeButtonSides(removeWildflower, "Remove", 60, 235, font, deepPurple, cloudBlue);
        makeButtonMiddle(haveISeenThisWildflower, "Have I seen this before?", 245, 125,
                font, deepPurple, cloudBlue);
        makeButtonSides(displayTypes, "Types", 490, 35,
                font, deepPurple, cloudBlue);
        makeButtonSides(displayLocations, "Locations", 490, 235,
                font, deepPurple, cloudBlue);
        makeButtonMiddleTB(save, "Save", 280, 35,
                font, deepPurple, cloudBlue);
        makeButtonMiddleTB(load, "Load", 280, 235,
                font, deepPurple, cloudBlue);

        ButtonListener buttonListener = new ButtonListener(wildflowerList);

        addWildflower.addActionListener(buttonListener);
        removeWildflower.addActionListener(buttonListener);
        haveISeenThisWildflower.addActionListener(buttonListener);
        displayTypes.addActionListener(buttonListener);
        displayLocations.addActionListener(buttonListener);
        save.addActionListener(buttonListener);
        load.addActionListener(buttonListener);
    }

    // MODIFIES: this
    // EFFECTS: initializes data
    public void initializeData() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    // Represents the listener of the buttons in the main menu of the GUI
    class ButtonListener implements ActionListener {
        private WildflowerList wildflowerList;

        public ButtonListener(WildflowerList wildflowerList) {
            this.wildflowerList = wildflowerList;
        }



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
            } else if (e.getActionCommand().equals("Types")) {
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

        // EFFECTS: opens window for user to input type, location and month of wildflower to add
        public void addWildflowerAction() {
            ImageIcon icon = new ImageIcon("wildflower-tracker-icon.png");
            String type = JOptionPane.showInputDialog(null,
                    "Enter the type of the wildflower:",
                    "Add Wildflower", JOptionPane.PLAIN_MESSAGE, icon,
                    null, "").toString();
            String location = JOptionPane.showInputDialog(null,
                    "Enter the location where you found the wildflower:",
                    "Add Wildflower", JOptionPane.PLAIN_MESSAGE, icon,
                    null, "").toString();
            String month = JOptionPane.showInputDialog(null,
                    "Enter the month when you found the wildflower:", "Add Wildflower",
                    JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();

            if (type != null && !type.isEmpty() && location != null && !location.isEmpty()
                    && month != null && !month.isEmpty()) {
                Wildflower wildflower = new Wildflower(type, location, month);
                wildflowerList.addWildflower(wildflower);
                JOptionPane.showMessageDialog(null, "Wildflower added successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.",
                        "Unsuccessful", JOptionPane.INFORMATION_MESSAGE, icon);
            }

        }

        // EFFECTS: opens window for user to select wildflower to remove from list
        public void removeWildflowerAction() {
        }

        private void haveISeenThisWildflowerAction() {
        }

        public void displayTypesAction() {
            List<String> wildflowerTypes = wildflowerList.getWildflowerTypes();
            StringBuilder message = new StringBuilder("Wildflower types in your collection:\n");
            for (String type : wildflowerTypes) {
                message.append(type).append("\n");
            }
            ImageIcon icon = new ImageIcon("wildflower-tracker-icon.png");
            JOptionPane.showMessageDialog(null, message.toString(), "Wildflower Types",
                    JOptionPane.INFORMATION_MESSAGE, icon);
            System.out.println("wildflowerList: " + wildflowerList.toString());

        }

        public void displayLocationsAction() {
        }

        // MODIFIES: WildflowerList.json
        // EFFECTS: saves the wildflower list to file
        public void saveAction() {
            try {
                jsonWriter.open();
                jsonWriter.write(wildflowerList);
                jsonWriter.close();
                String message = "Your wildflowers have been successfully saved!";
                ImageIcon icon = new ImageIcon("wildflower-tracker-icon.png");
                JOptionPane.showMessageDialog(null, message, "Wildflower Types",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to save wildflower list to " + JSON_STORE);
            }

        }

        // MODIFIES: WildflowerList.json
        // EFFECTS: loads wildflower list from file
        public void loadAction() {
            ImageIcon icon = new ImageIcon("wildflower-tracker-icon.png");
            String message = "Your wildflowers have successfully loaded!";
            try {
                wildflowerList = jsonReader.read();
                JOptionPane.showMessageDialog(null, message
                        + JSON_STORE, "Load Successful", JOptionPane.INFORMATION_MESSAGE, icon);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to read from file: "
                        + JSON_STORE, "Load Error", JOptionPane.ERROR_MESSAGE, icon);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid data found in file: "
                        + JSON_STORE, "Load Error", JOptionPane.ERROR_MESSAGE, icon);
            }

        }
    }
}
