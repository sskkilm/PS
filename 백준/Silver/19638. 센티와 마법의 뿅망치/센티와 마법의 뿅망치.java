import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int centiH = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        for (int i = 0; i < T; i++) {
            int root = pq.poll();

            if (centiH > root) {
                System.out.println("YES");
                System.out.println(cnt);
                return;
            }

            if (root != 1) {
                pq.add(root / 2);
            } else {
                pq.add(root);
            }
            cnt++;
        }
        if (centiH > pq.peek()) {
            System.out.println("YES");
            System.out.println(cnt);
            return;
        }

        System.out.println("NO");
        System.out.println(pq.peek());
    }
}