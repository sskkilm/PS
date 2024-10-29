import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());

            long answer = 0;

            long left = 1;
            long right = N;
            while (left <= right) {
                long mid = (left + right) / 2;
                double sum = (double) mid * (mid + 1) / 2;
                if (sum <= N) {
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(answer);
        }
    }

}