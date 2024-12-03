// Subclass ExpressPackage
public class ExpressPackage extends Package {
    public ExpressPackage(String trackingID, String destination, double weight) {
        super(trackingID, destination, weight);
    }

    @Override
    public double calculateShippingCost() {
        return weight * 4.0;
    }
}
