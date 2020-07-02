public class Position {
    private long positionID;
    private long employeeID;
    private String position;

    public Position() {
    }

    public Position(long positionID, long employeeID, String position) {
        this.positionID = positionID;
        this.employeeID = employeeID;
        this.position = position;
    }

    public long getPositionID() {
        return positionID;
    }

    public void setPositionID(long positionID) {
        this.positionID = positionID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
