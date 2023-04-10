public class Node<T extends Comparable<T>> {
    T val;
    Node<T> left, right;

    public Node(T v) {
        val = v;
    }

    public T getValue() {
        return val;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public boolean onlyOne() {
        return (getLeft() == null && getRight() != null) || (getLeft() != null && getRight() == null);
    }
}
