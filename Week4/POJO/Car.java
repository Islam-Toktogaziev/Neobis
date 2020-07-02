public class Car {
    private long carID;
    private String carName;
    private long typeID;
    private String color;
    private long priceID;
    private double engineDisplacement;

    public Car(){
    }

    public Car(long carID, String carName, long typeID, String color, long priceID, double engineDisplacement) {
        this.carID = carID;
        this.carName = carName;
        this.typeID = typeID;
        this.color = color;
        this.priceID = priceID;
        this.engineDisplacement = engineDisplacement;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPriceID() {
        return priceID;
    }

    public void setPriceID(long priceID) {
        this.priceID = priceID;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }
}