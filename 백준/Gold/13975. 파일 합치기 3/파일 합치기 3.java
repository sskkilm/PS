import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        PriorityQueue<Long> pq = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long total = 0;
            while (pq.size() != 1) {
                long A = pq.poll();
                long B = pq.poll();
                long sum = A + B;
                total += sum;
                pq.add(sum);
            }

            System.out.println(total);
        }
    }
}