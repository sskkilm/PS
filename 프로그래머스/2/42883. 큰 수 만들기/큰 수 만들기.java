class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int prev = 0;
        int len = number.length() - k;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = prev; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    prev = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}