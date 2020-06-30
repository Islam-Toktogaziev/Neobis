public class Customers {
    private long CustomerID;
    private String CustomerName;
    private String Reputation;
    private String Adress;
    private String Email;
    private String Number;

    public Customers() {
    }

    public Customers(long customerId, String customerName, String reputation, String adress, String email, String number) {
        this.CustomerID = customerId;
        this.CustomerName = customerName;
        this.Reputation = reputation;
        this.Adress = adress;
        this.Email = email;
        this.Number = number;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerId(long customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getReputation() {
        return Reputation;
    }

    public void setReputation(String reputation) {
        Reputation = reputation;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

}
