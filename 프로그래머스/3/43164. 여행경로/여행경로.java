import java.util.*;

class Solution {
    public List<String> ans = new ArrayList<>();
    public boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(ans);

        answer = ans.get(0).split(" ");

        return answer;
    }

    public void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) {
            ans.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1],path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}