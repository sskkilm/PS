import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.add(c);
                }
                if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    else {
                        stack.add(c);
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            stack.clear();
        }

    }
}
