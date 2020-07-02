public class OrderDetails {
    private long orderID;
    private long carID;
    private long priceID;

    public OrderDetails() {
    }

    public OrderDetails(long orderID, long carID, long priceID) {
        this.orderID = orderID;
        this.carID = carID;
        this.priceID = priceID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getPriceID() {
        return priceID;
    }

    public void setPriceID(long priceID) {
        this.priceID = priceID;
    }
}
