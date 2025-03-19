import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        int count = set.size();

        Map<String, Integer> map = new HashMap<>();

        int answerLt = 0;
        int answerRt = 0;
        int minLength = Integer.MAX_VALUE;

        int lt = 0;
        for (int rt = 0; rt < gems.length; rt++) {
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);

            while (map.size() == count) {
                int length = rt - lt;
                if (length < minLength) {
                    minLength = length;
                    answerLt = lt + 1;
                    answerRt = rt + 1;
                }

                if (map.get(gems[lt]) == 1) {
                    map.remove(gems[lt]);
                } else {
                    map.put(gems[lt], map.get(gems[lt]) - 1);
                }
                lt++;
            }
        }

        return new int[]{answerLt, answerRt};
    }
}