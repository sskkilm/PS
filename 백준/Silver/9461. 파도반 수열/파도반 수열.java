import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            memo = new long[N + 1];
            System.out.println(p(N));
        }
    }

    public static long p(int N) {
        if (N == 1 || N == 2 || N == 3) {
            return 1;
        }
        if (N == 4 || N == 5) {
            return 2;
        }

        if (memo[N] == 0) {
            memo[N] = p(N - 1) + p(N - 5);
        }

        return memo[N];
    }
}