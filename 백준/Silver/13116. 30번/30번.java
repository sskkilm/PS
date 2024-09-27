import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = check(A, B);
            System.out.println(10 * result);
        }
    }

    public static int check(int A, int B) {
        while(true) {
            if (A == B) {
                return A;
            } else if (A > B) {
                if (A % 2 == 0) {
                    A /= 2;
                } else {
                    A = (A - 1) / 2;
                }
            } else {
                if (B % 2 == 0) {
                    B /= 2;
                } else {
                    B = (B - 1) / 2;
                }
            }
        }
    }
}