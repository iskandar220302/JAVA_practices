public class Main {
    public static void main(String[] args) {
        StackOnQueue stack = new StackOnQueue();
        stack.push(1);
        stack.push(2);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
        System.out.println("Stack elements: " + stack);
    }
}
