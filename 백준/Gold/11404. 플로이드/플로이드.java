import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int INF = 100000 * (100 - 1) + 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            arr[v1][v2] = Math.min(arr[v1][v2], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    System.out.print(0 + " ");
                }
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}