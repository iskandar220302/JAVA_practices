import java.util.Scanner;

public class TestGenericStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericStack<String> stack = new GenericStack<>();

        System.out.println("Введите строки (введите 'exit' для завершения ввода):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            stack.push(input);
        }

        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
