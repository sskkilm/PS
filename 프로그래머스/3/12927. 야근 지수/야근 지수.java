import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        for (int work : works) {
            sum += work;
        }

        if (sum <= n) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        for (int i = 0; i < n; i++) {
            pq.add(pq.poll() - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            long num = pq.poll();
            answer += num * num;
        }

        return answer;
    }
}