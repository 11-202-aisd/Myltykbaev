import java.util.NoSuchElementException;

public class Queue<T> {
    private Stack<T> st1;
    private Stack<T> st2;

    public Queue() {
        st1 = new Stack<>(1024);
        st2 = new Stack<>(1024);
    }

    public void add(T value) {
        st1.push(value);
    }

    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public T remove() {
        if(isEmpty()) throw new NoSuchElementException();
        if(st2.isEmpty()) {
            while(!st1.isEmpty()) st2.push(st1.pop());
        }
        return st2.pop();
    }

    public T peek() {
        if(isEmpty()) throw new NoSuchElementException();
        if(st2.isEmpty()) {
            while(!st1.isEmpty()) st2.push(st1.pop());
        }
        return st2.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(5);
        q.add(2);
        q.add(7);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.remove();
    }

}
