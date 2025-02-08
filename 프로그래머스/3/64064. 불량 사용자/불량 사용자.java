import java.util.HashSet;
import java.util.Set;

class Solution {
    public int n;
    public boolean[] visited;
    public int[] output;
    public Set<Set<String>> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        n = banned_id.length;
        visited = new boolean[user_id.length];
        output = new int[n];
        dfs(0, user_id, banned_id);

        return set.size();
    }

    public void dfs(int depth, String[] user_id, String[] banned_id) {
        if (depth == n) {
            Set<String> result = new HashSet<>();
            for (int i = 0; i < n; i++) {
                result.add(user_id[output[i]]);
            }
            set.add(result);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && match(user_id[i], banned_id[depth])) {
                visited[i] = true;
                output[depth] = i;
                dfs(depth + 1, user_id, banned_id);
                visited[i] = false;
            }
        }
    }

    public boolean match(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return false;
        }

        for (int i = 0; i < banned_id.length(); i++) {
            char c = banned_id.charAt(i);
            if (c != '*' && c != user_id.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}