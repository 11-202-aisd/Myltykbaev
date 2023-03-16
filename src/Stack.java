import java.util.NoSuchElementException;

public class Stack<T> {
    private int capacity;
    private T[] arr;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        size = -1;
    }

    public boolean isFull() {
        return size == capacity - 1;
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public void push(T value) {
        if(isFull()) throw new ArrayIndexOutOfBoundsException();
        arr[++size] = value;
    }

    public T pop() {
        if(isEmpty()) throw new NoSuchElementException();
        return arr[size--];
    }

    public T peek() {
        if(isFull()) throw new NoSuchElementException();
        return arr[size];
    }
}
