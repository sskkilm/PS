import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        Map<String, Set<String>> reportLogMap = new HashMap<>();
        for (String r : report) {
            String[] s = r.split(" ");
            String a = s[0];
            String b = s[1];

            if (!reportLogMap.containsKey(a)) {
                reportLogMap.put(a, new HashSet<>());
            }
            Set<String> set = reportLogMap.get(a);
            set.add(b);
            reportLogMap.put(a, set);
        }

        Map<String, Integer> reportedCountMap = new HashMap<>();
        for (String key : reportLogMap.keySet()) {
            Set<String> strings = reportLogMap.get(key);
            for (String string : strings) {
                reportedCountMap.put(string, reportedCountMap.getOrDefault(string, 0) + 1);
            }
        }

        answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            if (!reportLogMap.containsKey(id_list[i])) {
                continue;
            }

            for (String string : reportLogMap.get(id_list[i])) {
                if (!reportedCountMap.containsKey(string)) {
                    continue;
                }

                if (reportedCountMap.get(string) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}