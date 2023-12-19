import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i%2 == 1) {
                answer.add(i);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}