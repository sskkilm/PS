import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) {
                return answer;
            }

            if (pq.size() == 1) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();

            pq.offer(first + second * 2);
            answer++;
        }

        return -1;
    }
}