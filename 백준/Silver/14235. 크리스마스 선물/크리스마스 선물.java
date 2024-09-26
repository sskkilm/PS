import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            int size = Integer.parseInt(strings[0]);
            if (size == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(-1);
                }
            } else {
                for (int j = 1; j <= size; j++) {
                    pq.add(Integer.parseInt(strings[j]));
                }
            }
        }
    }
}