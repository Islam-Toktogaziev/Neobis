public class Shipping {
    private long shippingID;
    private String shippingType;
    private double shippingCost;
    private long regionID;

    public Shipping() {
    }

    public Shipping(long shippingID, String shippingType, double shippingCost, long regionID) {
        this.shippingID = shippingID;
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.regionID = regionID;
    }

    public long getShippingID() {
        return shippingID;
    }

    public void setShippingID(long shippingID) {
        this.shippingID = shippingID;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }
}
