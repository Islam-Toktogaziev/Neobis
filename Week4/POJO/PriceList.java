public class PriceList {
    private long priceID;
    private double price;

    public PriceList() {
    }

    public PriceList(long priceID, double price) {
        this.priceID = priceID;
        this.price = price;
    }

    public long getPriceID() {
        return priceID;
    }

    public void setPriceID(long priceID) {
        this.priceID = priceID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
