package Semistr;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RadixSort {
    static int count_iters = 0;
    static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
            count_iters++;
        }

        for (int s = 1; max / s > 0; s *= 10)
            countingSortForRadix(arr, s);
    }

    static void countingSortForRadix(int[] arr, int s) {
        int[] countingArray = {0,0,0,0,0,0,0,0,0,0};
        count_iters++;
        for (int i = 0; i < arr.length; i++) {
            countingArray[(arr[i] / s) % 10]++;
            count_iters++;
        }
        for (int i = 1; i < 10; i++) {
            countingArray[i] += countingArray[i - 1];
            count_iters++;
        }
        int[] outputArray = new int[arr.length];
        count_iters++;
        for (int i = arr.length - 1; i >= 0; i--) {
            outputArray[--countingArray[(arr[i] / s) % 10]] = arr[i];
            count_iters++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = outputArray[i];
            count_iters++;
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("C:\\Users\\mylty\\IdeaProjects\\Algorithms\\src\\data.txt");
        FileWriter o = new FileWriter("C:\\Users\\mylty\\IdeaProjects\\Algorithms\\src\\output.txt");
        o.write("Время;Итерации;Количество;Максимальное\n");
        Scanner scan = new Scanner(f);
        int i = 1;
        while(scan.hasNextLine()) {
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            OptionalInt max = Arrays.stream(arr).max();
            count_iters = 0;
            long start = System.nanoTime();
            radixSort(arr);
            long finish = System.nanoTime();
            double elapsed = (finish - start)/1_000_000.0;
            System.out.printf(i + ") Время выполнения - %,9.3f ms. Количество итераций - %s. Количество чисел - %s. Максимальный разряд в наборе - %s\n", elapsed, count_iters, arr.length, max.getAsInt());
            i++;
            o.write(elapsed + ";" + count_iters + ";" + arr.length + ";" + max.getAsInt() + "\n");
        }
        o.close();
        f.close();
    }

}
