import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        Deque<String> deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            String alphabet = null;
            if (flag == 1) {
                alphabet = st.nextToken();
                deque.addLast(alphabet);
                stack.push(flag);
            } else if (flag == 2) {
                alphabet = st.nextToken();
                deque.addFirst(alphabet);
                stack.push(flag);
            } else if (flag == 3) {
                if (!deque.isEmpty()) {
                    if (stack.pop() == 1) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
        }

        if (deque.isEmpty()) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : deque) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}