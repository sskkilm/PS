import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int[] arr;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges, (o1, o2) -> o1.cost - o2.cost);

        int cnt = 0;
        int sum = 0;
        for (Edge edge : edges) {
            int fa = find(edge.from);
            int fb = find(edge.to);

            if (fa != fb) {
                union(fa, fb);
                sum += edge.cost;
                cnt++;
                if (cnt == n - 1) {
                    break;
                }
            }
        }

        answer = sum;

        return answer;
    }

    public int find(int v) {
        if (v == arr[v]) {
            return v;
        } else {
            return arr[v] = find(arr[v]);
        }
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            arr[fa] = fb;
        }
    }
}