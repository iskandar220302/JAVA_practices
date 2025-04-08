public class Car {
    String model;
    String license;
    String color;
    int year;

    public Car(String model, String license, String color, int year) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;
    }

    public Car() {
        this.model = "Undefined";
        this.license = "00000";
        this.color = "?";
        this.year = -1;
    }

    public Car(String model, int year) {
        this.model = model;
        this.license = "AAA111";
        this.color = "";
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return this.model + " " + this.license + " " + this.color + " " + this.year;
    }

    public int getAge() {
        final int CURRENT_YEAR = 2024;
        return CURRENT_YEAR - year;
    }
}