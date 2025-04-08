import java.util.ArrayList;
//содержатся различные статические методы:
public class Main {

    // 1. Метод для удаления дубликатов из  ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 2. Алгоритм линейного поиска элемента в массиве
    public static <E> int linearSearch(E[] array, E target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // 3. Поиск наибольшего элемента в массиве с помощью метода compareTo() интерфейса Comparable
    public static class Circle implements Comparable<Circle> {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public int compareTo(Circle other) {
            return Double.compare(this.radius, other.radius);
        }

        public static Circle findMax(Circle[] circles) {
            Circle max = circles[0];
            for (Circle circle : circles) {
                if (circle.compareTo(max) > 0) {
                    max = circle;
                }
            }
            return max;
        }
    }

    // 4. Поиск наибольшего элемента в двумерном массиве с помощью метода compareTo() интерфейса Comparable
    public static <E extends Comparable<E>> E findMax(E[][] array) {
        E max = array[0][0];
        for (E[] row : array) {
            for (E element : row) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Тестирование метода removeDuplicates
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");
        list.add("red");
        list.add("orange");
        list.add("pink");

        ArrayList<String> result = removeDuplicates(list);
        System.out.println("Удаление дубликатов: " + result);

        //  метод linearSearch
        String[] array = {"red", "pink", "blue", "orange"};
        int index = linearSearch(array, "pink");
        System.out.println("Линейный поиск: " + index); // 2

        // Тестирование метода findMax для массива Circle
        Circle[] circles = {new Circle(3), new Circle(5), new Circle(2)};
        Circle maxCircle = Circle.findMax(circles);
        System.out.println("Наибольший круг: " + maxCircle.getRadius()); // 5

        // Тестирование метода findMax для двумерного массива
        Integer[][] array2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Integer max = findMax(array2D);
        System.out.println("Наибольший элемент в двумерном массиве: " + max);
    }
}
