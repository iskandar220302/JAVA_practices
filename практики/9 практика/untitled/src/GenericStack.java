public class GenericStack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
//который реализует стек с использованием массива.
    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public void push(E o) {
        if (size == elements.length) {
            System.out.println("Массив заполнен. Увеличиваем размер массива.");
            E[] newElements = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = o;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E o = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("стек: [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
