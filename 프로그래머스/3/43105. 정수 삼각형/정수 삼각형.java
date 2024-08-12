class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int height = triangle.length;
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < height; i++) {
            int col = triangle[i].length;
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == col - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
            }
        }

        int max = dp[height - 1][0];
        for (int i = 1; i < triangle[height - 1].length; i++) {
            max = Math.max(max, dp[height - 1][i]);
        }
        answer = max;

        return answer;
    }
}