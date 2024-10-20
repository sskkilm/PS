import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            dp[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = 0; j < count; j++) {
                int task = Integer.parseInt(st.nextToken());
                max = Math.max(max, dp[task]);
            }

            dp[i] += max;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}