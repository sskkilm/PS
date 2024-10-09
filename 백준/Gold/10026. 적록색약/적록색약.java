import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static char[][] arr;
    public static boolean[][] visited1;
    public static boolean[][] visited2;
    public static int cnt1, cnt2;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    cnt1++;
                    dfs1(i, j);
                }
                if (!visited2[i][j]) {
                    cnt2++;
                    dfs2(i, j);
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    public static void dfs1(int x, int y) {
        visited1[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > N - 1) continue;
            if (ny < 0 || ny > N - 1) continue;

            if (!visited1[nx][ny] && arr[nx][ny] == arr[x][y]) {
                dfs1(nx, ny);
            }
        }
    }

    public static void dfs2(int x, int y) {
        visited2[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > N - 1) continue;
            if (ny < 0 || ny > N - 1) continue;

            if (!visited2[nx][ny]) {
                if (arr[x][y] == 'B' && arr[nx][ny] == 'B') {
                    dfs2(nx, ny);
                } else if (arr[x][y] != 'B' && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
                    dfs2(nx, ny);
                }
            }
        }
    }
}