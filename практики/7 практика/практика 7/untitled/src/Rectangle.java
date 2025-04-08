public class Rectangle extends GeometricObject {
    private double width;
    private double height;
//Описывает прямоугольник с шириной и высотой
//Содержит конструкторы для создания прямоугольника с различными параметрами
//Методы для получения и установки ширины и высоты, вычисления площади и периметра
    /** Создает по умолчанию заданный прямоугольник */
    public Rectangle() {
    }

    /** Создает прямоугольник с указанной шириной и высотой */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** Создает прямоугольник с указанной шириной, высотой, цветом и заливкой */
    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    /** Возвращает ширину */
    public double getWidth() {
        return width;
    }

    /** Присваивает новую ширину */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Возвращает высоту */
    public double getHeight() {
        return height;
    }

    /** Присваивает новую высоту */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Возвращает площадь */
    public double getArea() {
        return width * height;
    }

    /** Возвращает периметр */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString(){
        return "Ширина " + width + " Высота " + height;
    }
}

