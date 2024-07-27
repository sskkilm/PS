import java.util.ArrayList;
import java.util.Collections;
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

        int n = data.length;

        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tuples.add(new Tuple(data[i]));
        }
        Collections.sort(tuples, (o1, o2) -> {
            if (o1.num[col - 1] == o2.num[col - 1]) {
                return o2.num[0] - o1.num[0];
            }
            return o1.num[col - 1] - o2.num[col - 1];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            Tuple tuple = tuples.get(i);
            int sum = 0;
            for (int j = 0; j < tuple.num.length; j++) {
                sum += tuple.num[j] % (i + 1);
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