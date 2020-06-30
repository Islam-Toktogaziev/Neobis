public class Car {
    private long carId;
    private String carName;
    private String cartype;
    private String color;
    private double engineDisplacement;

    public Car(){

    }

    public Car(long carId, String carName, String cartype, String color, double engineDisplacement) {
        this.carId = carId;
        this.carName = carName;
        this.cartype = cartype;
        this.color = color;
        this.engineDisplacement = engineDisplacement;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

}
