import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        // 2중 포문을 돌면서 연속된 부분 문자열을 set에 저장 (중복 제거)
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }

        System.out.println(set.size());
    }
}