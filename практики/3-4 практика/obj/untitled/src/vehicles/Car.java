package vehicles;

public class Car extends Vehicle {
    public Car(String model, String license, String color, int year, String ownerName, String insuranceNumber) {
        super(model, license, color, year, ownerName, insuranceNumber);
        setEngineType("Internal Combustion");
    }

    public String vehicleType() {
        return "Car";
    }

    public String toString() {
        return "Vehicle Type: " + vehicleType() +
                ", Model: " + getModel() +
                ", License: " + getLicense() +
                ", Color: " + getColor() +
                ", Year: " + getYear() +
                ", Owner Name: " + getOwnerName() +
                ", Insurance Number: " + getInsuranceNumber() +
                ", Engine Type: " + getEngineType();
    }
}