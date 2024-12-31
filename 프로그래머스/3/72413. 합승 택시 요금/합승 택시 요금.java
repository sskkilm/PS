class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] fare : fares) {
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];

            arr[v1][v2] = Math.min(arr[v1][v2], cost);
            arr[v2][v1] = Math.min(arr[v2][v1], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (arr[i][a] == Integer.MAX_VALUE || arr[i][b] == Integer.MAX_VALUE || arr[i][s] == Integer.MAX_VALUE) {
                continue;
            }
            sum = Math.min(sum, arr[i][a] + arr[i][b] + arr[i][s]);
        }

        answer = sum;

        return answer;
    }
}