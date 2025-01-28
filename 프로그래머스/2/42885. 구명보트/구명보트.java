import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int p : people) {
            list.add(p);
        }
        Collections.sort(list, Collections.reverseOrder());

        Stack<Integer> stack = new Stack<>();
        for (int n : list) {
            if (!stack.isEmpty()) {
                if (stack.peek() + n <= limit) {
                    stack.pop();
                    answer++;
                    continue;
                }
            }
            stack.push(n);
        }

        answer += stack.size();

        return answer;
    }
}