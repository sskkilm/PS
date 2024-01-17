import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = c - 96;

            int tmp = 1;
            for (int j = 0; j < i; j++) {
                tmp *= 31;
                tmp %= 1234567891;
            }

            num = num * tmp % 1234567891;
            sum += num % 1234567891;
        }
        System.out.println(sum);
    }
}

