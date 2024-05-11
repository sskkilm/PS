import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int N, M, H;
    public static int limit;
    public static int[][] arr;
    public static boolean flag = false;
    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int st = i;
            for (int j = 1; j <= H; j++) {
                if (arr[j][st] == 1) {
                    st++;
                } else if (arr[j][st] == 2) {
                    st--;
                }
            }
            if (st != i) {
                return false;
            }
        }
        return true;
    }
    public static void dfs(int depth) {
        if (flag) return;
        if (depth == limit) {
            if (check()) {
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = 2;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                    arr[i][j + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[a][b + 1] = 2;
        }

        for (int i = 0; i < 4; i++) {
            limit = i;
            dfs(0);

            if (flag) break;
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }

        System.out.println(limit);
    }
}