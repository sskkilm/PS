import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<String> list = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for (int i = 0; i < list.size(); i++) {
            s = s.replace(list.get(i), String.valueOf(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}