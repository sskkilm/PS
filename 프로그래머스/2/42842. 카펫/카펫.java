class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int sum = brown + yellow;
        for (int i = sum; i >= 0; i--) {
            if (sum % i == 0) {
                int w = i;
                int h = sum / i;
                if ((w - 2) * (h - 2) == yellow) {
                    answer = new int[]{w, h};
                    break;
                }
            }
        }

        return answer;
    }
}