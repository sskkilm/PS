import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]) * 28);
        }

        List<Integer> ans = new ArrayList<>();
        int t = calculate(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int p = calculate(s[0]);
            int d = map.get(s[1]);
            if (p + d - 1 < t) {
                ans.add(i + 1);
            }
        }
        answer = ans.stream().mapToInt(e -> e).toArray();

        return answer;
    }

    public int calculate(String date) {
        String[] split = date.split("\\.");
        int y = Integer.parseInt(split[0]) * 12 * 28;
        int m = Integer.parseInt(split[1]) * 28;
        int d = Integer.parseInt(split[2]);
        return y + m + d;
    }
}