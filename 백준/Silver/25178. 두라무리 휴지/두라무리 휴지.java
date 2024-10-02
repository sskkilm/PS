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

        // 정렬하여 두 단어를 재배열했을 때 동일한지 확인
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

        // 두 문자열의 첫번째와 마지막이 일치하는지 확인
        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(N - 1) != s2.charAt(N - 1)) {
            System.out.println("NO");
            return;
        }

        // 모음을 제거했을 때 두 문자열이 일치하는지 확인
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
        if (!replacedS1.equals(replacedS2)) {
            System.out.println("NO");
            return;
        }

        // 모두 만족하는 경우
        System.out.println("YES");
    }
}