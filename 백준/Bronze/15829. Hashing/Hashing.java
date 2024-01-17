import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();

        long sum = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            sum += (S.charAt(i) - 'a' + 1) * pow % M;
            pow = pow * 31 % M;
        }
        long hash = sum % M;
        System.out.println(hash);
    }
}