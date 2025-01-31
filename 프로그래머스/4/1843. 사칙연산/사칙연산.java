class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;

        int[] num = new int[n];
        for (int i = 0; i < arr.length; i += 2) {
            num[i / 2] = Integer.parseInt(arr[i]);
        }

        int[][] max_dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max_dp[i][j] = Integer.MIN_VALUE;
            }
        }

        int[][] min_dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min_dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int interval = 0; interval < n; interval++) {
            for (int start = 0; start < n - interval; start++) {
                int end = start + interval;

                if (interval == 0) {
                    max_dp[start][end] = num[start];
                    min_dp[start][end] = num[start];
                } else {
                    for (int k = start; k < end; k++) {
                        if ("+".equals(arr[k * 2 + 1])) {
                            max_dp[start][end] = Math.max(max_dp[start][end], max_dp[start][k] + max_dp[k + 1][end]);
                            min_dp[start][end] = Math.min(min_dp[start][end], min_dp[start][k] + min_dp[k + 1][end]);
                        } else {
                            max_dp[start][end] = Math.max(max_dp[start][end], max_dp[start][k] - min_dp[k + 1][end]);
                            min_dp[start][end] = Math.min(min_dp[start][end], min_dp[start][k] - max_dp[k + 1][end]);
                        }
                    }
                }
            }
        }

        return max_dp[0][n - 1];
    }
}