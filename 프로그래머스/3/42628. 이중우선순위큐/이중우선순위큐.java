import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            String[] strings = operation.split(" ");
            String op = strings[0];
            int num = Integer.parseInt(strings[1]);
            if (op.equals("I")) {
                maxHeap.add(num);
                minHeap.add(num);
            } else {
                if (num == 1) {
                    if (maxHeap.isEmpty()) {
                        continue;
                    }
                    Integer max = maxHeap.poll();
                    minHeap.remove(max);
                } else {
                    if (minHeap.isEmpty()) {
                        continue;
                    }
                    Integer min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            answer = new int[]{0, 0};
        } else if (maxHeap.isEmpty()) {
            Integer min = minHeap.poll();
            answer = new int[]{min, min};
        } else if (minHeap.isEmpty()) {
            Integer max = maxHeap.poll();
            answer = new int[]{max, max};
        } else {
            Integer max = maxHeap.poll();
            Integer min = minHeap.poll();
            answer = new int[]{max, min};
        }

        return answer;
    }
}