import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int cnt, N;
    public static boolean[][] visited;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void dfs(int x, int y, int[][] arr) {
        visited[x][y] = true;
        cnt++;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > N - 1) continue;
            if (ny < 0 || ny > N - 1) continue;

            if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, arr);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, arr);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int tmp : list) {
            System.out.println(tmp);
        }
    }
}