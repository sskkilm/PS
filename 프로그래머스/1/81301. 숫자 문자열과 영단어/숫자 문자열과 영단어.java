import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<String> list = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for (String s1 : list) {
            s = s.replace(s1, String.valueOf(list.indexOf(s1)));
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}