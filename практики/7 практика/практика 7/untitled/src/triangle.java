public class triangle extends  GeometricObject{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
/*
Класс triangle является подклассом GeometricObject
 и представляет собой треугольник. У класса есть поля
  для хранения сторон треугольника, а также методы для
  расчета площади и периметра треугольника, установки и
  получения значений сторон, а также метод toString для
  вывода информации о треугольнике в виде строки.
 */
    public triangle(){

    }
    public triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if ((side1 + side2 < side3) || (side2 + side3 < side1) || (side1 + side3 < side2)) {
            throw new IllegalTriangleException("Неверные стороны треугольника!");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException {
        if ((side1 + side2 < side3) || (side2 + side3 < side1) || (side1 + side3 < side2)) {
            throw new IllegalTriangleException("Неверные стороны треугольника!");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.setColor(color);
        this.setFilled(filled);
    }
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    public void setSide1(double side1){ this.side1 = side1; }
    public void setSide2(double side2) { this.side2 = side2; }
    public void setSide3(double side3) { this.side3 = side3; }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public String toString(){
        return "Треугольник: сторона1 = " + side1 + " сторона2 = " + side2 + " сторона3 = " + side3 + " цвет: " + this.getColor() + " Заливка: " + this.isFilled() + " площадь: " + getArea() + " периметр: " + getPerimeter();
    }
}
