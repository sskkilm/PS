import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            for(int j=0; j<2; j++) {
                if (map.containsKey(clothes[i][1])) {
                    map.get(clothes[i][1]).add(clothes[i][0]);
                } else {
                    map.put(clothes[i][1], new HashSet<String>());
                    map.get(clothes[i][1]).add(clothes[i][0]);
                }
                
            }
        }
        for (String key: map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }
        return answer - 1;
    }
}