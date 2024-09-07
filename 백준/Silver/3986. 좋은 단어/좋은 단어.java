import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Character> stack = null;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (c == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}