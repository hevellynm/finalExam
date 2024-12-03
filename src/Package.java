import java.util.*;
import java.util.regex.*;

// Abstract class Package
abstract class Package {
    protected String trackingID;
    protected String destination;
    protected double weight;

    // Constructor
    public Package(String trackingID, String destination, double weight) {
        if (!validateTrackingID(trackingID)) {
            throw new IllegalArgumentException("Invalid tracking ID format.");
        }
        if (!validateDestination(destination)) {
            throw new IllegalArgumentException("Invalid destination format.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }

        this.trackingID = trackingID;
        this.destination = destination;
        this.weight = weight;
    }

    // Abstract method to calculate shipping cost
    public abstract double calculateShippingCost();

    // Method to validate tracking ID
    public static boolean validateTrackingID(String trackingID) {
        return trackingID.matches("PKG\\d{5}");
    }

    // Method to validate destination address
    public static boolean validateDestination(String destination) {
        return destination.matches("\\d+\\s+\\w+(\\s\\w+)*");
    }

    @Override
    public String toString() {
        return String.format("TrackingID: %s, Destination: %s, Weight: %.2f", trackingID, destination, weight);
    }
}