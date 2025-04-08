package app;

import vehicles.Car;
import vehicles.ElectricCar;

public class Main {
    public static void main(String[] args) {
        // создаем экземпляры класса Car и ElectricCar
        Car car = new Car("Toyota Camry", "ABC123", "Black", 2020, "John Doe", "INS12345");
        ElectricCar electricCar = new ElectricCar("Tesla Model 3", "XYZ789", "Red", 2021, "Jane Doe", "INS54321", 75);

        // изменяем некоторые свойства
        car.setYear(2021);
        car.setOwnerName("John Smith");
        car.setInsuranceNumber("INS67890");

        // вывод информации
        System.out.println(car);
        System.out.println("Тип автомобиля: " + car.vehicleType());

        System.out.println();

        electricCar.setBatteryCapacity(80); // изменяем емкость батареи
        electricCar.setOwnerName("Jane Smith");
        electricCar.setInsuranceNumber("INS98765");

        // вывод информации о электромобиле
        System.out.println(electricCar);
        System.out.println("Тип автомобиля: " + electricCar.vehicleType());
    }
}