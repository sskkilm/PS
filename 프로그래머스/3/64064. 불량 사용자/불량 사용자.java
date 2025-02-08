import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int n;
    public boolean[] visited;
    public Set<List<String>> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        n = banned_id.length;
        visited = new boolean[user_id.length];
        dfs(0, user_id, banned_id);

        return set.size();
    }

    public void dfs(int depth, String[] user_id, String[] banned_id) {
        if (depth == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    list.add(user_id[i]);
                }
            }
            set.add(list);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && match(user_id[i], banned_id[depth])) {
                visited[i] = true;
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