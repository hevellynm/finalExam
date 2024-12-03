import java.util.Scanner;

public class MainInteractive {

    public static void main(String[] args) {
        CourierManager manager = new CourierManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("===============================");
        System.out.println(" Welcome to Delivery Dilemmas!");
        System.out.println("===============================");

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a new package");
            System.out.println("2. Display all packages and shipping costs");
            System.out.println("3. Sort packages by weight");
            System.out.println("4. Search for a package by Tracking ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add a new package
                    System.out.print("Enter package type (Standard/Express): ");
                    String packageType = scanner.nextLine().trim();

                    System.out.print("Enter tracking ID: ");
                    String trackingID = scanner.nextLine().trim();

                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine().trim();

                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    try {
                        Package pkg;
                        if (packageType.equalsIgnoreCase("Standard")) {
                            pkg = new StandardPackage(trackingID, destination, weight);
                        } else if (packageType.equalsIgnoreCase("Express")) {
                            pkg = new ExpressPackage(trackingID, destination, weight);
                        } else {
                            System.out.println("Invalid package type! Please choose Standard or Express.");
                            break;
                        }
                        manager.addPackage(pkg);
                        System.out.println("Package added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Display all packages
                    System.out.println("Package List:");
                    manager.displayPackages();
                    break;

                case 3: // Sort packages by weight
                    manager.sortPackagesByWeight();
                    System.out.println("Packages sorted by weight!");
                    System.out.println("Sorted Package List:");
                    manager.displayPackages();
                    break;

                case 4: // Search for a package by Tracking ID
                    System.out.print("Enter Tracking ID: ");
                    String searchTrackingID = scanner.nextLine().trim();

                    Package foundPackage = manager.searchPackageByTrackingID(searchTrackingID);
                    if (foundPackage != null) {
                        System.out.println("Package Found:");
                        System.out.printf("%s | Cost: $%.2f%n", foundPackage, foundPackage.calculateShippingCost());
                    } else {
                        System.out.println("Package not found!");
                    }
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("Thank you for using Delivery Dilemmas!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}