import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(arr[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int num = arr[i];
            if (num > stack.peek()) {
                while (!stack.isEmpty() && num > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(0 + " ");
                } else {
                    sb.append(map.get(stack.peek()) + " ");
                }
                stack.push(num);
            } else {
                sb.append(map.get(stack.peek()) + " ");
                stack.push(num);
            }
        }

        System.out.println(sb);
    }
}