package ui;

import model.WildflowerList;
import model.Wildflower;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Wildflower Application
// Code structure below adapted from Teller App:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public class WildflowerApp {

    private static final Scanner input = new Scanner(System.in);
    private static WildflowerList wildflowerList;
    private static final String JSON_STORE = "./data/WildflowerList.json";

    // MODIFIES: this
    // EFFECTS: runs a menu for managing a WildflowerList
    public WildflowerApp() {
        wildflowerList = new WildflowerList("My Wildflower Collection");
        boolean keepRunning = true;
        while (keepRunning) {
            displayMenu();
            int choice = input.nextInt();
            input.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    addWildflower();
                    break;
                case 2:
                    removeWildflower();
                    break;
                case 3:
                    haveISeenThisWildflower();
                    break;
                default:
                    keepRunning = handleChoice(choice);
                    break;
            }
        }
        System.out.println("Goodbye and happy exploring!");
    }

    // EFFECTS: processes user command
    private boolean handleChoice(int choice) {
        switch (choice) {
            case 4:
                displayWildflowerTypes();
                return true;
            case 5:
                displayWildflowerLocations();
                return true;
            case 6:
                saveWildflowerList();
                return true;
            case 7:
                loadWildflowerList();
                return true;
            case 8:
                return false;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                return true;
        }
    }

    // EFFECTS: display menu of options to user
    private static void displayMenu() {
        System.out.println("\nWelcome to the Wildflower Tracker App!");
        System.out.println("Please choose an option:");
        System.out.println("1. Add a wildflower");
        System.out.println("2. Remove a wildflower");
        System.out.println("3. Have I seen this wildflower before?");
        System.out.println("4. Display all wildflower types seen so far");
        System.out.println("5. Display all locations for a specific wildflower type");
        System.out.println("6. Save wildflower list to file");
        System.out.println("7. Load wildflower list from file");
        System.out.println("8. Return to nature");
    }

   // MODIFIES: this
   // EFFECTS: adds a Wildflower to the WildflowerList with type, location and month
    private static void addWildflower() {
        System.out.print("Enter the type of the wildflower: ");
        String type = input.nextLine();
        System.out.print("Enter the location of the wildflower: ");
        String location = input.nextLine();
        System.out.print("Enter the month when the wildflower was seen (e.g. January): ");
        String month = input.nextLine();
        Wildflower wildflower = new Wildflower(type, location, month);
        wildflowerList.addWildflower(wildflower);
        System.out.println(type + " added to the collection!");
    }

    // MODIFIES: this
    // EFFECTS: removes a Wildflower from the WildflowerList with type, location and month
    // that matches the given type, location and month
    private static void removeWildflower() {
        System.out.print("Enter the type of the wildflower you wish to remove: ");
        String type = input.nextLine();
        System.out.print("Enter the location of the wildflower you wish to remove: ");
        String location = input.nextLine();
        System.out.print("Enter the month when the wildflower was seen (e.g. January): ");
        String month = input.nextLine();
        boolean success = wildflowerList.removeWildflower(type, location, month);
        if (success) {
            System.out.println(type + " removed from the collection!");
        } else {
            System.out.println(type + " not found in the collection.");
        }
    }

    // EFFECTS: return true if given type is found in WildflowerList, otherwise return false
    private static void haveISeenThisWildflower() {
        System.out.print("Enter the type of the wildflower: ");
        String type = input.nextLine();
        Boolean seen = wildflowerList.haveISeenThisWildflower(type);
        if (seen) {
            System.out.println("Yes, you have seen " + type + " before!");
        } else {
            System.out.println("No, you have not seen " + type + " before.");
        }
    }

    // EFFECTS: return true if given type is found in WildflowerList, otherwise return false
    private static void displayWildflowerTypes() {
        System.out.println("Wildflower types in the collection:");
        wildflowerList.getWildflowerTypes().forEach(System.out::println);
    }

    // EFFECTS: returns a list of all the locations of Wildflowers whose type matched given type
    private static void displayWildflowerLocations() {
        System.out.print("Enter the type of the wildflower: ");
        String type = input.nextLine();
        System.out.println("Locations where " + type + " was seen:");
        wildflowerList.getWildflowerLocations(type).forEach(System.out::println);
    }

    // EFFECTS: saves the wildflower list to file
    private void saveWildflowerList() {
        try {
            JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
            jsonWriter.open();
            jsonWriter.write(wildflowerList);
            jsonWriter.close();
            System.out.println("Saved " + wildflowerList.getTitle() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWildflowerList() {
        try {
            JsonReader jsonReader = new JsonReader(JSON_STORE);
            wildflowerList = jsonReader.read();
            System.out.println("Loaded " + wildflowerList.getTitle() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}



