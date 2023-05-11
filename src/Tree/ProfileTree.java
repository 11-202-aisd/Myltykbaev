package Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ProfileTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mylty\\IdeaProjects\\Algorithms\\src\\Semistr\\data.txt"));
        BTree t = new BTree(8);
        Random r = new Random();


        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        long start = System.nanoTime();
        for (int x : arr) {
            t.insert(x);
        }
        long delta = System.nanoTime() - start;
        System.out.println("Average time of inserting: " + ((double) (delta / 10000)));


        int[] find_index = new int[100];
        for (int i = 0; i < 100; i++) {
            find_index[i] = arr[r.nextInt(10000)];
        }
        start = System.nanoTime();
        for (int x : find_index) {
            t.search(x);
        }
        delta = System.nanoTime() - start;
        System.out.println("Average time of searching: " + ((double) (delta / 100)));

        Set<Integer> remove_set = new HashSet<>();
        for(int i = 0; i < 1000; i++) {
            remove_set.add(arr[r.nextInt(10000)]);
        }
        start = System.nanoTime();
        for(int x: remove_set) {
            t.remove(x);
        }
        delta = System.nanoTime() - start;
        System.out.println("Average time of removing: " + ((double) (delta / 1000)));
    }
}
