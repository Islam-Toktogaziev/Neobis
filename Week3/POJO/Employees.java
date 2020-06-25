public class Employees {
    private long EmployeeId;
    private String EmployeeName;
    private String Position;
    private String salary;
    private String Adress;
    private String Email;
    private String Number;

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Employees(long employeeId, String employeeName, String position, String salary, String adress, String email, String number) {
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        Position = position;
        this.salary = salary;
        Adress = adress;
        Email = email;
        Number = number;
    }
}
