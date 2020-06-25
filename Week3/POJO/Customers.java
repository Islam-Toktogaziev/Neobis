public class Customers {
    private long CustomerId;
    private String CustomerName;
    private String Reputation;
    private String Adress;
    private String Email;
    private String Number;

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
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

    public Customers(long customerId, String customerName, String reputation, String adress, String email, String number) {
        CustomerId = customerId;
        CustomerName = customerName;
        Reputation = reputation;
        Adress = adress;
        Email = email;
        Number = number;
    }
}
