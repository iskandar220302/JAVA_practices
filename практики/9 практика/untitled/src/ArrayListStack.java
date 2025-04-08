import java.util.ArrayList;

public class ArrayListStack<E> extends ArrayList<E> {
    public int getSize() {
        return size();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public void push(E o) {
        add(o);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return remove(size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return "стек: " + super.toString();
    }
}
