import java.util.*;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        List<List<Node>> graph1 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph1.add(new ArrayList<>());
        }
        List<List<Node>> graph2 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            graph1.get(v1).add(new Node(v2, cost));
            graph2.get(v2).add(new Node(v1, cost));
        }

        int[] dist1 = new int[N + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(X, 0));
        dist1[X] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist1[cur.v] < cur.cost) continue;

            for (Node next : graph1.get(cur.v)) {
                int nc = dist1[cur.v] + next.cost;
                if (nc < dist1[next.v]) {
                    dist1[next.v] = nc;
                    pq.add(new Node(next.v, nc));
                }
            }
        }

        int[] dist2 = new int[N + 1];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(X, 0));
        dist2[X] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist2[cur.v] < cur.cost) continue;

            for (Node next : graph2.get(cur.v)) {
                int nc = dist2[cur.v] + next.cost;
                if (nc < dist2[next.v]) {
                    dist2[next.v] = nc;
                    pq.add(new Node(next.v, nc));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int sum = dist1[i] + dist2[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}