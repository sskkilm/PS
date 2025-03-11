import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        int quotient = s / n;

        int remainder = s % n;

        int idx = 0;
        for (int i = 0; i < n - remainder; i++) {
            answer[idx++] = quotient;
        }
        for (int i = 0; i < remainder; i++) {
            answer[idx++] = quotient + 1;
        }

        return answer;
    }
}