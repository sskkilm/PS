import java.util.*;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

class Solution {
    public List<List<Node>> graph;
    public HashSet<Integer> summitSet;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }

        summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        return dijkstra(n, gates, summits);
    }

    private int[] dijkstra(int n, int[] gates, int[] summits) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (intensity[cur.v] < cur.cost) continue;

            for (Node next : graph.get(cur.v)) {
                int nextCost = Math.max(cur.cost, next.cost);

                if (intensity[next.v] > nextCost) {
                    intensity[next.v] = nextCost;

                    if (!summitSet.contains(next.v)) {
                        pq.add(new Node(next.v, nextCost));
                    }
                }
            }
        }

        Arrays.sort(summits);
        
        int s = 0;
        int min = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (min > intensity[summit]) {
                s = summit;
                min = intensity[summit];
            }
        }

        return new int[]{s, min};
    }
}