import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tuple {
    int[] num;

    public Tuple(int[] num) {
        this.num = num;
    }
}

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            list.add(sum);
        }

        int tmp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            tmp = tmp ^ list.get(i);
        }

        answer = tmp;

        return answer;
    }
}