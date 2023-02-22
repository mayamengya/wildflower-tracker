package ui;

import model.WildflowerList;
import model.Wildflower;

import java.util.Scanner;

public class WildflowerApp {

    private static Scanner input = new Scanner(System.in);
    private static WildflowerList wildflowerList;

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

    private boolean handleChoice(int choice) {
        switch (choice) {
            case 4:
                displayWildflowerTypes();
                return true;
            case 5:
                displayWildflowerLocations();
                return true;
            case 6:
                return false;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                return true;
        }
    }


    private static void displayMenu() {
        System.out.println("\nWelcome to the Wildflower Tracker App!");
        System.out.println("Please choose an option:");
        System.out.println("1. Add a wildflower");
        System.out.println("2. Remove a wildflower");
        System.out.println("3. Have I seen this wildflower before?");
        System.out.println("4. Display all wildflower types seen so far");
        System.out.println("5. Display all locations for a specific wildflower type");
        System.out.println("6. Return to nature");
    }

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

    private static void displayWildflowerTypes() {
        System.out.println("Wildflower types in the collection:");
        wildflowerList.getWildflowerTypes().forEach(System.out::println);
    }

    private static void displayWildflowerLocations() {
        System.out.print("Enter the type of the wildflower: ");
        String type = input.nextLine();
        System.out.println("Locations where " + type + " was seen:");
        wildflowerList.getWildflowerLocations(type).forEach(System.out::println);
    }
}



