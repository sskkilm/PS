class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int st, int[][] computers) {
        visited[st] = true;

        for (int i = 0; i < computers[st].length; i++) {
            if (st == i) {
                continue;
            }

            if (computers[st][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}