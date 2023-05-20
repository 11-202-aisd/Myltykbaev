import java.util.Scanner;

public class FastCombining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество вершин: ");
        int n = scan.nextInt();
        int[] vertex = new int[n];
        for (int i = 0; i < n; i++) {
            vertex[i] = i;
        }
        System.out.print("Введите количество соединений: ");
        n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String pair = scan.nextLine();
            int a = Integer.parseInt(pair.split(" ")[0]);
            int b = Integer.parseInt(pair.split(" ")[1]);
            int min = Math.min(vertex[b], vertex[a]);
            int max = min == vertex[a] ? vertex[b] : vertex[a];
            for (int j = 0; j < vertex.length; j++) {
                if (max == vertex[j]) {
                    vertex[j] = min;
                }
            }
            for (int x : vertex) {
                System.out.println(x);
            }
        }
        System.out.print("Введите количество проверок: ");
        n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String pair = scan.nextLine();
            int a = Integer.parseInt(pair.split(" ")[0]);
            int b = Integer.parseInt(pair.split(" ")[1]);
            if (vertex[b] == vertex[a]) System.out.println(true);
            else System.out.println(false);
        }
    }
}
