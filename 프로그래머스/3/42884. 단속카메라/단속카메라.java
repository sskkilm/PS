import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(int[][] routes) {
        List<Node> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(new Node(route[0], route[1]));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int answer = 1;

        int prev = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            Node cur = list.get(i);

            if (cur.start <= prev) {
                prev = Math.min(prev, cur.end);
                continue;
            }

            answer++;
            prev = cur.end;
        }

        return answer;
    }
}