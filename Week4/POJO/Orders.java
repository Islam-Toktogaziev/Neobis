import java.util.Date;

public class Orders {
    private long orderID;
    private long customerID;
    private long shippingID;
    private Date date;
    private String status;

    public Orders() {
    }

    public Orders(long orderID, long customerID, long shippingID, Date date, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.date = date;
        this.status = status;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public long getShippingID() {
        return shippingID;
    }

    public void setShippingID(long shippingID) {
        this.shippingID = shippingID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}