class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int len = s.length();
        if (len == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len / 2; i >= 1; i--) {
            int a = len / i;
            int b = len % i;
            int cnt = 0;
            String cur = s.substring(0, i);
            for (int j = 0; j < a; j++) {
                String next = s.substring(j * i, j * i + i);
                if (cur.equals(next)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        sb.append(cnt);
                    }
                    sb.append(cur);
                    cur = next;
                    cnt = 1;
                }
            }
            if (cnt != 1) {
                sb.append(cnt);
            }
            sb.append(cur);
            sb.append(s.substring(len - b));
            answer = Math.min(answer, sb.toString().length());
            sb.delete(0, sb.length());
        }

        return answer;
    }
}