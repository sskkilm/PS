import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int N;
    public boolean[] visited;
    public List<Integer> list;

    public int solution(int[] cards) {
        int answer = 0;

        List<List<Integer>> boxs = new ArrayList<>();

        N = cards.length;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                list = new ArrayList<>();
                dfs(i, cards);
                boxs.add(list);
            }
        }

        if (boxs.size() == 1) {
            return 0;
        }

        Collections.sort(boxs, (o1, o2) -> o2.size() - o1.size());

        answer = boxs.get(0).size() * boxs.get(1).size();

        return answer;
    }

    public void dfs(int i, int[] cards) {
        visited[i] = true;
        list.add(cards[i]);

        if (!visited[cards[i] - 1]) {
            dfs(cards[i] - 1, cards);
        }
    }
}