import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();
        dfs(n, 1, 3);

        return list.toArray(new int[list.size()][]);
    }

    public void dfs(int n, int from, int to) {
        if (n == 0) {
            return;
        }

        int mid = find(from, to);
        dfs(n - 1, from, mid);
        list.add(new int[]{from, to});
        dfs(n - 1, mid, to);
    }

    public int find(int from, int to) {
        for (int i = 1; i <= 3; i++) {
            if (i != from && i != to) {
                return i;
            }
        }
        return -1;
    }
}