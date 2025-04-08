public class ComparableCircle extends Circle{

    public int compareTo(ComparableCircle p) {
        return Double.compare(this.getArea(), p.getArea());
    }
}
/*
Наследуется от класса Circle
Реализует интерфейс Comparable для сравнения объектов типа ComparableCircle по площади*/