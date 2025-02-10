import java.util.ArrayList;
import java.util.List;

class Traffic {
    int start;
    int end;

    public Traffic(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String[] lines) {
        List<Traffic> list = new ArrayList<>();
        for (String line : lines) {
            String[] s = line.split(" ");
            String time = s[1];
            String term = s[2];

            String[] split = time.split("\\.");
            String sss = split[1];

            String[] split1 = split[0].split(":");
            String hh = split1[0];
            String mm = split1[1];
            String ss = split1[2];

            int hh_ms = Integer.parseInt(hh) * 1000 * 3600;
            int mm_ms = Integer.parseInt(mm) * 1000 * 60;
            int ss_ms = Integer.parseInt(ss) * 1000;
            int end = ss_ms + mm_ms + hh_ms + Integer.parseInt(sss);
            int start = end - (int) (Double.parseDouble(term.substring(0, term.length() - 1)) * 1000) + 1;
            list.add(new Traffic(start, end));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            int standard = list.get(i).end;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).start < standard + 1000 && list.get(j).end >= standard) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}