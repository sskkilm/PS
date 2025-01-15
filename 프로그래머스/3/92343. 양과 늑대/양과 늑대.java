class Solution {
    public int answer;

    public int solution(int[] info, int[][] edges) {
        answer = 1;

        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited, info, edges);

        return answer;
    }

    private void dfs(int cur, int sheep, int wolf, boolean[] visited, int[] info, int[][] edges) {
        visited[cur] = true;

        if (info[cur] == 0) {
            sheep++;
            answer = Math.max(answer, sheep);
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (visited[v1] && !visited[v2]) {
                boolean[] newVisited = visited.clone();
                dfs(v2, sheep, wolf, newVisited, info, edges);
            }
        }
    }
}