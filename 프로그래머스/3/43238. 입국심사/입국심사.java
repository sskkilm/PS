class Solution {
    public long solution(int n, int[] times) {
        long answer = (long) 1e18;

        long left = 0;
        long right = answer;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid, times) >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public long check(long mid, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += mid / time;
        }

        return cnt;
    }
}