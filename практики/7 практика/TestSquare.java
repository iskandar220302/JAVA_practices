public class TestSquare {
    public static void main(String[] args) {
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
