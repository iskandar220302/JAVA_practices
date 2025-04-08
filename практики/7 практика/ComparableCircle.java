public class ComparableCircle extends Circle{

    public int compareTo(ComparableCircle p) {
        return Double.compare(this.getArea(), p.getArea());
    }
}
