public class Region {
    private long regionID;
    private long customerID;
    private String region;

    public Region() {
    }

    public Region(long regionID, long customerID, String region) {
        this.regionID = regionID;
        this.customerID = customerID;
        this.region = region;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
