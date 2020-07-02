import java.util.Date;

public class Contracts {
    private long contractID;
    private long orderID;
    private long employeeID;
    private long customerID;
    private long carID ;
    private long priceID;
    private long shippingID;
    private Date date;

    public Contracts() {
    }

    public Contracts(long contractID, long orderID, long employeeID, long customerID, long carID, long priceID, long shippingID, Date date) {
        this.contractID = contractID;
        this.orderID = orderID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.carID = carID;
        this.priceID = priceID;
        this.shippingID = shippingID;
        this.date = date;
    }

    public long getContractID() {
        return contractID;
    }

    public void setContractID(long contractID) {
        this.contractID = contractID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
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
}