import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            String[] arr = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = st.nextToken();
            }

            Deque<String> deque = new ArrayDeque<>();
            deque.add(arr[0]);

            for (int j = 1; j < N; j++) {
                String s = deque.peekFirst();
                if (s.compareTo(arr[j]) >= 0) {
                    deque.addFirst(arr[j]);
                } else {
                    deque.addLast(arr[j]);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
