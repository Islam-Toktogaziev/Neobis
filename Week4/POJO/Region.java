public class Region {
    private long regionID;
    private String region;

    public Region() {
    }

    public Region(long regionID, String region) {
        this.regionID = regionID;
        this.region = region;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
