import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N, answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static int[][] arr;

    public static void dfs(int depth, int start) {
        if (depth == N / 2) {
            int startSum = 0;
            int linkSum = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        startSum += (arr[i][j] + arr[j][i]);
                    }
                    if (!visited[i] && !visited[j]) {
                        linkSum += (arr[i][j] + arr[j][i]);
                    }
                }
            }

            if (startSum == linkSum) {
                System.out.println(0);
                System.exit(0);
            }

            answer = Math.min(answer, Math.abs(startSum - linkSum));
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N];
        dfs(0, 0);

        System.out.println(answer);
    }
}