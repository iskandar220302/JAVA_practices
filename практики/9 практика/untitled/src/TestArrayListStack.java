import java.util.Scanner;

public class TestArrayListStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayListStack<String> stack = new ArrayListStack<>();

        System.out.println("Введите пять строк:");
        for (int i = 0; i < 5; i++) {
            stack.push(scanner.nextLine());
        }

        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
