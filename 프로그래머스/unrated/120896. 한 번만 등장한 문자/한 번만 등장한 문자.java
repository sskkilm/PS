import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char key : map.keySet()
        ) {
            if (map.get(key) == 1) {
                sb.append(key);
            }
        }
        String result = sb.toString();
        char[] ans = result.toCharArray();
        Arrays.sort(ans);
        answer = String.valueOf(ans);
        return answer;
    }
}