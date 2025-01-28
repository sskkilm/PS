import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        int len = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().substring(0, len);
    }
}