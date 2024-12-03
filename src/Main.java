public class Main {
    public static void main(String[] args) {
        CourierManager manager = new CourierManager();

        //Tests
        try {

            manager.addPackage(new StandardPackage("PKG12345", "123 Davie Street", 10));
            manager.addPackage(new ExpressPackage("PKG67890", "456 Commox Street", 5));
            manager.addPackage(new StandardPackage("PKG54321", "789 Broughton Street", 15));
            manager.addPackage(new ExpressPackage("PKG67890", "100 Nelson Street", 25));


            System.out.println("Packages before sorting:");
            manager.displayPackages();

            System.out.println("\nSorting packages by weight...");
            manager.sortPackagesByWeight();

            System.out.println("\nPackages after sorting:");
            manager.displayPackages();

            System.out.println("\nSearching for package with ID 'PKG67890'...");
            Package foundPackage = manager.searchPackageByTrackingID("PKG67890");
            if (foundPackage != null) {
                System.out.printf("Found package: %s%n", foundPackage);
            } else {
                System.out.println("Package not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}