import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Deque<Character> stack = null;
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            stack = new ArrayDeque<>();
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        if (stack.peek() == c) {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag && !stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}