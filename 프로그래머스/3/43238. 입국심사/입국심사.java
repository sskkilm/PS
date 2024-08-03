class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }
        
        long left = 0;
        long right = max * n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid, times) >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static long check(long mid, int[] times) {
        long n = 0;
        for (int i = 0; i < times.length; i++) {
            n += mid / times[i];
        }
        return n;
    }
}