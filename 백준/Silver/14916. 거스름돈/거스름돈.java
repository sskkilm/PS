import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        int result = dp(n);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(result);
    }

    public static int dp(int n) {
        if (n <= 1 || n == 3) {
            return Integer.MAX_VALUE;
        }
        if (n == 2 || n == 5) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }

        if (memo[n] == 0) {
            memo[n] = Math.min(dp(n - 2), dp(n - 5)) + 1;
        }

        return memo[n];
    }
}