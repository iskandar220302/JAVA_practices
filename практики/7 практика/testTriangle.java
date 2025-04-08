import java.util.Scanner;
public class testTriangle {
    public static void main(String[] args) {
        System.out.println("Введите сторону1 треугольника: ");
        Scanner scan = new Scanner(System.in);
        double s1 = scan.nextDouble();
        System.out.println("Введите сторону2 треугольника: ");
        double s2 = scan.nextDouble();
        System.out.println("Введите сторону3 треугольника: ");
        double s3 = scan.nextDouble();
        System.out.println("Введите цвет треугольника: ");
        String cl = scan.next();
        System.out.println("Введите заливку треугольника (false - без заливки; true - с заливкой: ");
        boolean fil = scan.nextBoolean();
        try {
        triangle trig = new triangle(s1, s2, s3, cl, fil);
        System.out.println(trig);
        }
        catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
        }

    }
}
