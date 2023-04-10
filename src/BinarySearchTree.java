public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public void add(T x) {
        Node<T> nx = new Node<>(x);
        if(root == null) {
            root = nx;
        }
        else {
            boolean flag = false;
            Node<T> current = root;
            while(!flag) {
                if(nx.getValue().compareTo(current.getValue()) <= 0) {
                    if(current.getLeft() == null) {
                        current.setLeft(nx);
                        flag = true;
                    }
                    current = current.getLeft();
                }
                else {
                    if(current.getRight() == null) {
                        current.setRight(nx);
                        flag = true;
                    }
                    current = current.getRight();
                }
            }
        }

    }

    public boolean contains(T x) {
        Node<T> current = root;
        while(!current.isLeaf()) {
            int diff = current.getValue().compareTo(x);
            if(diff == 0) {
                return true;
            }
            else if(diff > 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return false;
    }

    private Node<T> removeRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (current.getValue().compareTo(value) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
        }
        if (current.getValue().compareTo(value) >= 0) {
            current.left = removeRecursive(current.left, value);
            return current;
        }
        T smallestValue = findSmallestValue(current.right);
        current.val = smallestValue;
        current.right = removeRecursive(current.right, smallestValue);
        return current;
    }

    public void remove(T value) {
        root = removeRecursive(root, value);
    }

    private T findSmallestValue(Node<T> root) {
        return root.left == null ? root.val : findSmallestValue(root.left);
    }

    public Node<T> search(T x) {
        Node<T> current = root;
        while(!current.isLeaf()) {
            int diff = current.getValue().compareTo(x);
            if(diff == 0) {
                return current;
            }
            else if(diff > 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return null;
    }

    public static <T extends Comparable<T>> void printTree(Node<T> r, int d) {
        if(r != null) {
            printTree(r.right, d + 1);
            for(int i = 1; i <= d; i++) {
                System.out.print(" ");
            }
            System.out.println(r.getValue());
            printTree(r.left, d + 1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(4);
        bst.add(2);
        bst.add(5);
        bst.add(1);
        bst.add(9);
        bst.add(10);
        bst.add(7);
        printTree(bst.root, 1);
    }
}
