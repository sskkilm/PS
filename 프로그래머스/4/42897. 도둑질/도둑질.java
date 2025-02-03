class Solution {
    public int solution(int[] money) {
        int n = money.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return money[0];
        }

        int[] dp_include_first = new int[n];
        dp_include_first[1] = money[0];
        for (int i = 2; i < n; i++) {
            dp_include_first[i] = Math.max(dp_include_first[i - 1], dp_include_first[i - 2] + money[i - 1]);
        }

        int[] dp_exclude_first = new int[n + 1];
        dp_exclude_first[2] = money[1];
        for (int i = 3; i <= n; i++) {
            dp_exclude_first[i] = Math.max(dp_exclude_first[i - 1], dp_exclude_first[i - 2] + money[i - 1]);
        }

        return Math.max(dp_include_first[n - 1], dp_exclude_first[n]);
    }
}