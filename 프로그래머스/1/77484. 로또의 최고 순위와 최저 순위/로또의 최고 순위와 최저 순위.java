import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int lotto : lottos) {
            if (lotto == 0) {
                cnt++;
            } else {
                set.add(lotto);
            }
        }

        int win = 0;
        for (int win_num : win_nums) {
            if (set.contains(win_num)) {
                win++;
            }
        }

        int min = win;
        int max = win + cnt;

        answer[0] = rank(max);
        answer[1] = rank(min);

        return answer;
    }

    public int rank(int cnt) {
        if (cnt <= 1) {
            return 6;
        }

        return 7 - cnt;
    }
}