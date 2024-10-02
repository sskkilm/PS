import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<String> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                numStack.push(sb.toString());
                sb = new StringBuilder();
                if (!opStack.isEmpty() && opStack.peek() == '+') {
                    int a = Integer.parseInt(numStack.pop());
                    int b = Integer.parseInt(numStack.pop());
                    numStack.push(String.valueOf(a + b));
                    opStack.pop();
                }
                opStack.push(c);
            }
        }
        numStack.push(sb.toString());
        if (!opStack.isEmpty() && opStack.peek() == '+') {
            int a = Integer.parseInt(numStack.pop());
            int b = Integer.parseInt(numStack.pop());
            numStack.push(String.valueOf(a + b));
            opStack.pop();
        }

        if (opStack.isEmpty()) {
            System.out.println(Integer.parseInt(numStack.pop()));
            return;
        }

        while (opStack.size() != 1) {
            int b = Integer.parseInt(numStack.pop());
            int a = Integer.parseInt(numStack.pop());
            numStack.push(String.valueOf(a + b));
            opStack.pop();
        }

        int b = Integer.parseInt(numStack.pop());
        int a = Integer.parseInt(numStack.pop());
        System.out.println(a - b);
    }
}