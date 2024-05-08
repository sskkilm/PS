import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int area, M, N;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void dfs(int x, int y, int[][] arr) {
        arr[x][y] = 1;
        area++;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > M - 1) continue;
            if (ny < 0 || ny > N - 1) continue;

            if (arr[nx][ny] == 0) {
                dfs(nx, ny, arr);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[M][N];
        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    area = 0;
                    dfs(i, j, arr);
                    list.add(area);
                    cnt++;
                }
            }
        }
        Collections.sort(list);

        System.out.println(cnt);
        for (int tmp : list) {
            System.out.print(tmp + " ");
        }
    }
}