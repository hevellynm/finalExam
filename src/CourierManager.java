import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// CourierManager class
class CourierManager {
    private ArrayList<Package> packages;

    public CourierManager() {
        this.packages = new ArrayList<>();
    }

    // Add a package to the list
    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    // Display all packages with their shipping costs
    public void displayPackages() {
        for (Package pkg : packages) {
            System.out.printf("%s, Shipping Cost: %.2f%n", pkg, pkg.calculateShippingCost());
        }
    }

    // Sort packages by weight using Bubble Sort
    public void sortPackagesByWeight() {
        int n = packages.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (packages.get(j).weight > packages.get(j + 1).weight) {
                    // Swap packages[j] and packages[j+1]
                    Collections.swap(packages, j, j + 1);
                }
            }
        }
    }

    // Search for a package by tracking ID using Binary Search
    public Package searchPackageByTrackingID(String trackingID) {
        // Ensure the list is sorted by tracking ID
        packages.sort(Comparator.comparing(p -> p.trackingID));

        int left = 0, right = packages.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Package midPackage = packages.get(mid);

            if (midPackage.trackingID.equals(trackingID)) {
                return midPackage;
            } else if (midPackage.trackingID.compareTo(trackingID) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }
}