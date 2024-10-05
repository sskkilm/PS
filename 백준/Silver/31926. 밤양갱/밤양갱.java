import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = dp(N);
        System.out.println(result + 2);
    }

    public static int dp(int n) {
        if (n == 1) {
            return 8;
        }

        if (n % 2 == 0) {
            return dp(n / 2) + 1;
        }

        return dp(n - 1);
    }
}