public class TestSquare {
    public static void main(String[] args) {
        //Основной класс для демонстрации работы с классом Square
        //Создает массив объектов различных геометрических фигур и выводит их площадь, если фигура реализует интерфейс Colorable, выводит инструкцию по раскрашиванию.
        GeometricObject[] objects = {
                new Circle(4),
                new Rectangle(6, 5),
                new Square(5),
                new Rectangle(7, 9),
                new Square(8, "Red", true),
        };
        for (GeometricObject obj : objects){
            System.out.println("Площадь " + obj.getArea());
            if (obj instanceof Colorable){
                ((Colorable) obj).howToColor();
            }
        }


    }
}
