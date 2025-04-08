public class TestComparable {
    public static void main(String[] args) {

        Rectangle rec1 = new Rectangle(20, 25);
        Rectangle rec2 = new Rectangle(50, 70);

        Circle cr1 = new Circle(10);
        Circle cr2 = new Circle(50);


        System.out.println(GeometricObject.max(rec1, cr2));
        System.out.println(GeometricObject.max(rec2, cr1));



    }
}
