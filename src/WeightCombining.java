import java.util.Scanner;

public class WeightCombining {
    /*
    int main() {
  int i, j, p, q, id[N], sz[N];
  for (i = 0; i < N; i++) {
    id[i] = i; sz[i] = 1;
  }
  while ( cin >> p >> q) {
    for (i = p; i != id[i]; i = id[i]) ;
    for (j = q; j != id[j]; j = id[j]) ; if (i == j) continue;
    if (sz[i] < sz[j]) {
      id[i] = j; sz[j] += sz[i];
      } else {
        id[j] = i; sz[i] += sz[j];
      }
      cout << " " << p << " " << q << endl;
    }
  }
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество вершин: ");
        int n = scan.nextInt();
        int[] vertex = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            vertex[i] = i + 1;
        }
        for (int i = 0; i < n; i++) weight[i] = 1;
        System.out.print("Введите количество соединений: ");
        int m = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < m; i++) {
            String pair = scan.nextLine();
            int p = Integer.parseInt(pair.split(" ")[0]);
            int q = Integer.parseInt(pair.split(" ")[1]);
            for (int j = p; j != vertex[p]; j++) {
                for (int k = q; k != vertex[q]; k++) {
                    if (k == j) break;
                    if (weight[j] < weight[k]) {
                        vertex[j] = k;
                        weight[k] += weight[j];
                    } else {
                        vertex[k] = j;
                        weight[j] += weight[k];
                    }
                }
                for (int x : vertex) {
                    System.out.println(x);
                }
            }
        }
    }
}
