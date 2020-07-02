public class CarType {
    private long typeID;
    private long carID;
    private String carType;

    public CarType() {
    }

    public CarType(long typeID, long carID, String carType) {
        this.typeID = typeID;
        this.carID = carID;
        this.carType = carType;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
