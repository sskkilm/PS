import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] dp;
    public List<List<Integer>> graph;

    public int solution(int[] sales, int[][] links) {
        int len = sales.length;
        dp = new int[len + 1][2];

        graph = new ArrayList<>();
        for (int i = 0; i < len + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] link : links) {
            graph.get(link[0]).add(link[1]);
        }

        dfs(1, sales);

        return Math.min(dp[1][0], dp[1][1]);
    }

    public void dfs(int n, int[] sales) {
        int sum = 0;
        boolean flag = false;
        int min = Integer.MAX_VALUE;

        for (int next : graph.get(n)) {
            dfs(next, sales);

            if (dp[next][1] < dp[next][0]) {
                flag = true;
            }
            min = Math.min(min, dp[next][1] - dp[next][0]);
            sum += Math.min(dp[next][0], dp[next][1]);
        }

        dp[n][1] = sales[n - 1] + sum;
        if (flag) {
            dp[n][0] = sum;
        } else {
            if (min == Integer.MAX_VALUE) {
                dp[n][0] = sum;
            } else {
                dp[n][0] = sum + min;
            }
        }
    }
}