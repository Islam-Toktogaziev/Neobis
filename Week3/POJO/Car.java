public class Car {
    private long carId;
    private String carNumber;
    private String cartype;
    private String color;
    private String engineDisplacement;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Car(){

    }

    public Car(long carId, String carNumber, String cartype, String color, String engineDisplacement) {
        this.carId = carId;
        this.carNumber = carNumber;
        this.cartype = cartype;
        this.color = color;
        this.engineDisplacement = engineDisplacement;
    }
}
