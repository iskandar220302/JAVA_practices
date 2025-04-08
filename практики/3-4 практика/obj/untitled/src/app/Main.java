package app;

import vehicles.Car;
import vehicles.ElectricCar;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Camry", "ABC123", "Red", 2020, "John Doe", "INS12345");
        ElectricCar eCar1 = new ElectricCar("Tesla Model 3", "XYZ789", "White", 2021, "Jane Smith", "INS54321", 75);

        // Изменить свойства с помощью сеттеров
        car1.setYear(2021);
        car1.setOwnerName("Johnathan Doe");

        eCar1.setBatteryCapacity(85);

        // Вывод информации
        System.out.println(car1);
        System.out.println();
        System.out.println(eCar1);
    }
}