import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int tmp = (100 - progresses[i]) % speeds[i];
            if (tmp == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else {
                q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        int previous = q.poll();
        int cnt = 1;
        while(!q.isEmpty()) {
            if (q.peek() <= previous) {
                q.poll();
                cnt++;
            } else {
                ans.add(cnt);
                previous = q.poll();
                cnt = 1;
            }
        }
        ans.add(cnt);
        
        return ans.stream().mapToInt(e->e).toArray();
    }
}