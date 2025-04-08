public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Toyota", "ABC123", "Silver", 2015);
        Car car3 = new Car("Honda", 2010);
        car1.setYear(2005);
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());

        System.out.println("Car 2 age: " + car2.getAge());
        System.out.println("Car 3 age: " + car3.getAge());
    }
}