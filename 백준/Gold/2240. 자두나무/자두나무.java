import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] dp = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            int tree = Integer.parseInt(br.readLine());

            for (int j = 0; j <= w; j++) {

                if (j == 0) {
                    if (tree == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                    continue;
                }

                if (j % 2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]); // 현재 위치와 열매가 떨어지는 위치가 같다면 +1, 움직였다면 다른 나무이니 +0
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1); // 움직여야 +1
                    }
                } else {
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]); // 움직여야 +1
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1); // 가만히 있어야 +1
                    }
                }
            }
        }

        int ans = 0;
        for (int k = 0; k <= w; k++) {
            ans = Math.max(ans, dp[t][w]);
        }

        System.out.println(ans);
    }
}