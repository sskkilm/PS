import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String s1, s2;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();

        answer = 0;
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) == s2.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == s2.length()) {
                answer++;
                i += s2.length() - 1;
            }
        }

        System.out.println(answer);
    }
}