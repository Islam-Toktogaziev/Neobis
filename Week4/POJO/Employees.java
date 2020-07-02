public class Employees {
    private long employeeID;
    private String employeeName;
    private long positionID;
    private double salary;
    private String address;
    private String email;
    private String number;

    public Employees() {
    }

    public Employees(long employeeID, String employeeName, long positionID, double salary, String address, String email, String number) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.positionID = positionID;
        this.salary = salary;
        this.address = address;
        this.email = email;
        this.number = number;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getPositionID() {
        return positionID;
    }

    public void setPositionID(long positionID) {
        this.positionID = positionID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}