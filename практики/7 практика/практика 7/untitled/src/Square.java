public class Square extends GeometricObject implements Colorable{
//Наследуется от класса GeometricObject и реализует интерфейс Colorable
//Описывает квадрат с длиной стороны
//Методы для получения и установки длины стороны, вычисления площади и периметра
    private double side;

    public Square(){
        this.side = 0;
    }
    public Square(double side){
        this.side = side;
    }

    public Square(double side, String color, boolean filled){
        super(color, filled);
        this.side = side;
    }


    public void howToColor(){
        System.out.println("Раскрасьте все четыре стороны: ");
    }

    public double getSide(){
        return side;
    }

    public void setSide(double side){
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }
    public String getColor(){
        return super.getColor();
    }
}
