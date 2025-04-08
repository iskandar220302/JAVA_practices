import java.util.ArrayList;
import java.util.Scanner;

class MyStack {
    private ArrayList<Object> list; // список для хранения элементов

    public MyStack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public void push(Object o) {
        list.add(o);
    }
}