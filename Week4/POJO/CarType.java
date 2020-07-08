public class CarType {
    private long typeID;
    private String carType;

    public CarType() {
    }

    public CarType(long typeID, String carType) {
        this.typeID = typeID;
        this.carType = carType;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
