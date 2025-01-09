class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        int maxUnitLength = s.length() / 2;
        for (int unitLength = 1; unitLength <= maxUnitLength; unitLength++) {
            String unit = s.substring(0, unitLength);
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            while (lastIndex <= s.length() - unitLength) {
                String str = s.substring(lastIndex, lastIndex + unitLength);
                if (str.equals(unit)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(unit);
                    } else {
                        sb.append(cnt).append(unit);
                    }
                    cnt = 1;
                    unit = str;
                }
                lastIndex += unitLength;
            }
            if (cnt == 1) {
                sb.append(unit);
            } else {
                sb.append(cnt).append(unit);
            }
            sb.append(s.substring(lastIndex));
            answer = Math.min(answer, sb.length());
        }

        if (answer == Integer.MAX_VALUE) {
            return 1;
        }

        return answer;
    }
}