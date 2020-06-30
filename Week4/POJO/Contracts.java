public class Contracts {
    private long ContractID;
    private long EmployeeID;
    private long CustomerID;
    private long CarID ;

    public Contracts() {
    }

    public Contracts(long contractID, long employeeID, long customerID, long carID) {
        this.ContractID = contractID;
        this.EmployeeID = employeeID;
        this.CustomerID = customerID;
        this.CarID = carID;
    }

    public long getContractID() {
        return ContractID;
    }

    public void setContractID(long contractID) {
        ContractID = contractID;
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long employeeID) {
        EmployeeID = employeeID;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    public long getCarID() {
        return CarID;
    }

    public void setCarID(long carID) {
        CarID = carID;
    }
}
