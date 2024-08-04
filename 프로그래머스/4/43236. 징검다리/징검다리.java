import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(distance);
        for (int rock : rocks) {
            list.add(rock);
        }
        Collections.sort(list);

        int left = 0;
        int right = list.get(list.size() - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(list, mid) >= list.size() - n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static int check(List<Integer> list, int dist) {
        int cnt = 1;

        int lt = 0;
        for (int rt = 1; rt < list.size(); rt++) {
            if (list.get(rt) - list.get(lt) >= dist) {
                cnt++;
                lt = rt;
            }
        }

        return cnt;
    }
}