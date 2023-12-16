import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int num : priorities) {
			pq.add(num);
		}
		while(!pq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					//answer++;
					if(i == location) {
						return answer;
                    }
                    answer++;
                    pq.poll();
				}
			}
		}  
        return -1;
    }
}