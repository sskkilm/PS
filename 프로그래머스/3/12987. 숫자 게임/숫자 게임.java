import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;

        int lt = 0;
        for (int rt = 0; rt < B.length; rt++) {
            if (A[lt] >= B[rt]) {
                continue;
            }

            sum++;
            lt++;
        }

        return sum;
    }
}