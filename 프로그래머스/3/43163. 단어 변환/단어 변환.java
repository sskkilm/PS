import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        answer = bfs(begin, target, words);

        if (answer == -1) {
            return 0;
        }

        return answer;
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return level;
                }

                for (String word : words) {
                    if (check(cur, word) && !visited.contains(word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public boolean check(String cur, String word) {
        int cnt = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1) {
            return true;
        }

        return false;
    }
}