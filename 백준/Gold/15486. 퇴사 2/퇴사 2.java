import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = p;
        }

        int max = 0;
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            if (i + arr[i][0] <= N) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
            }
        }

        System.out.println(dp[N]);
    }
}