import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        long sum1 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }

        long sum2 = 0;
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        long total = sum1 + sum2;
        if (total % 2 != 0) {
            return -1;
        }

        long std = total / 2;
        int len = queue1.length + queue2.length;
        int cnt = 0;
        for (int i = 0; i < len * 2; i++) {
            if (sum1 == std) {
                return cnt;
            } else if (sum1 > std) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
                cnt++;
            } else {
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
                cnt++;
            }
        }
        if (sum1 == std) {
            return cnt;
        }

        return -1;
    }
}