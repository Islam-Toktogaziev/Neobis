public class PriceList {
    private long priceID;
    private long carID;
    private double price;

    public PriceList() {
    }

    public PriceList(long priceID, long carID, double price) {
        this.priceID = priceID;
        this.carID = carID;
        this.price = price;
    }

    public long getPriceID() {
        return priceID;
    }

    public void setPriceID(long priceID) {
        this.priceID = priceID;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
