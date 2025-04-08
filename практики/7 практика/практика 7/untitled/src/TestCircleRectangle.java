public class TestCircleRectangle {
    //Основной класс для демонстрации работы с классами Circle и Rectangle
    //Создает объекты круга и прямоугольника, выводит информацию о них
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("Круг " + circle.toString());
        System.out.println("Радиус равен " + circle.getRadius());
        System.out.println("Площадь равна " + circle.getArea());
        System.out.println("Диаметр равен " + circle.getDiameter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("\nПрямоугольник " + rectangle.toString());
        System.out.println("Площадь равна " + rectangle.getArea());
        System.out.println("Периметр равен " +
                rectangle.getPerimeter());
    }
}