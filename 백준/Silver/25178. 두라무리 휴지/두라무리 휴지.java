import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < N; i++) {
            if (charArray1[i] != charArray2[i]) {
                System.out.println("NO");
                return;
            }
        }

        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(N - 1) != s2.charAt(N - 1)) {
            System.out.println("NO");
            return;
        }

        String replacedS1 = s1
                .replace("a", "")
                .replace("e", "")
                .replace("i", "")
                .replace("o", "")
                .replace("u", "");
        String replacedS2 = s2
                .replace("a", "")
                .replace("e", "")
                .replace("i", "")
                .replace("o", "")
                .replace("u", "");
        for (int i = 0; i < replacedS1.length(); i++) {
            if (replacedS1.charAt(i) != replacedS2.charAt(i)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}