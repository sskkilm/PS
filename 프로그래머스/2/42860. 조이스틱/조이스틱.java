class Solution {
    public int solution(String name) {
        int answer = 0;

        int len = name.length();
        int move = len - 1;
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int nextA = i + 1;
            while (nextA < len && name.charAt(nextA) == 'A') {
                nextA++;
            }

            move = Math.min(move, i * 2 + len - nextA);
            move = Math.min(move, (len - nextA) * 2 + i);
        }

        answer += move;

        return answer;
    }
}