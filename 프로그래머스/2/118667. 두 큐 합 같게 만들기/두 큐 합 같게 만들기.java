import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long sum1 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int e : queue1) {
            sum1 += e;
            q1.add(e);
        }

        long sum2 = 0;
        Queue<Integer> q2 = new LinkedList<>();
        for (int e : queue2) {
            sum2 += e;
            q2.add(e);
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int len = queue1.length;

        int cnt = 0;
        while (true) {
            if (cnt > 3 * len) {
                break;
            }
            if (sum1 == sum2) {
                answer = cnt;
                break;
            } else if (sum1 > sum2) {
                int e = q1.poll();
                q2.add(e);
                sum1 -= e;
                sum2 += e;
            } else {
                int e = q2.poll();
                q1.add(e);
                sum1 += e;
                sum2 -= e;
            }
            cnt++;
        }

        return answer;
    }
}