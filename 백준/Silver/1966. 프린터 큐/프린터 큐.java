import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Print {
    int idx;
    int num;

    public Print(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        PriorityQueue<Integer> pq = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            Queue<Print> queue = new LinkedList<>();
            pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
                queue.add(new Print(j, num));
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                if (pq.peek() == queue.peek().num) {
                    pq.poll();
                    if (queue.poll().idx == idx) {
                        System.out.println(answer + 1);
                        break;
                    }
                    answer++;
                } else {
                    queue.add(queue.poll());
                }
            }
        }
    }
}