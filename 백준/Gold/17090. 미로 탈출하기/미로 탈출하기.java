import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, cnt;
    public static char[][] arr;
    public static boolean[][] dp;
    public static boolean[][] visited;
    public static Map<Character, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        map.put('U', new int[]{-1, 0});
        map.put('R', new int[]{0, 1});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});

        cnt = 0;
        dp = new boolean[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dp[i][j] = dfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean dfs(int x, int y) {
        int[] dir = map.get(arr[x][y]);
        int nx = x + dir[0];
        int ny = y + dir[1];
        if (nx < 0 || nx > N - 1) {
            return true;
        }
        if (ny < 0 || ny > M - 1) {
            return true;
        }

        if (visited[nx][ny]) {
            if (dp[nx][ny]) {
                return true;
            }
            return false;
        } else {
            visited[nx][ny] = true;
            dp[nx][ny] = dfs(nx, ny);
            return dp[nx][ny];
        }

    }
}