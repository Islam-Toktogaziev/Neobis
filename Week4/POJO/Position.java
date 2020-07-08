public class Position {
    private long positionID;
    private String position;

    public Position() {
    }

    public Position(long positionID, String position) {
        this.positionID = positionID;
        this.position = position;
    }

    public long getPositionID() {
        return positionID;
    }

    public void setPositionID(long positionID) {
        this.positionID = positionID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
