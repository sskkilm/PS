import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        Deque<Character> stack = null;
        while (true) {
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            boolean flag = true;
            stack = new ArrayDeque<>();
            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != c) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != c) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (flag && !stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}