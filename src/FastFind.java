import java.util.ArrayList;
import java.util.Scanner;

public class FastFind {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество вершин: ");
        int n = scan.nextInt();
        int[] vertex = new int[n];
        for (int i = 0; i < n; i++) {
            vertex[i] = i;
        }
        System.out.print("Введите количество соединений: ");
        int m = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < m; i++) {
            String pair = scan.nextLine();
            int p = Integer.parseInt(pair.split(" ")[0]);
            int q = Integer.parseInt(pair.split(" ")[1]);
            int t = vertex[p];
            if (t == vertex[q]) continue;
            for (int j = 0; j < n; j++) {
                if (vertex[j] == t) vertex[j] = vertex[q];
            }
            for (int x : vertex) {
                System.out.println(x);
            }
        }
    }
}
