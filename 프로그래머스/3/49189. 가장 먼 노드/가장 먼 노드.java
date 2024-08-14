import java.util.*;

class Solution {
    public int N;
    public List<List<Integer>> graph;
    public int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        N = n;
        int[] arr = bfs();

        int max = Arrays.stream(arr).max().getAsInt();
        if (max == 0) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                cnt++;
            }
        }

        answer = cnt;

        return answer;
    }

    public int[] bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        return dist;
    }
}