import java.time.LocalDate;
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
            map.put(s[0], Integer.parseInt(s[1]));
        }

        String[] split = today.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate todayDate = LocalDate.of(year, month, day);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] s = privacy.split(" ");
            String[] ymd = s[0].split("\\.");
            int y = Integer.parseInt(ymd[0]);
            int m = Integer.parseInt(ymd[1]);
            int d = Integer.parseInt(ymd[2]);
            LocalDate date = LocalDate.of(y, m, d);

            if (!date.plusMonths(map.get(s[1])).isAfter(todayDate)) {
                list.add(i + 1);
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}