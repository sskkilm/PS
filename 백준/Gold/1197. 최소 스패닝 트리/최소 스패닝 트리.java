import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

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
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[V + 1];

        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.v]) {
                visited[cur.v] = true;
                sum += cur.cost;
                cnt++;
                if (cnt == V) {
                    break;
                }

                for (Node next : graph.get(cur.v)) {
                    if (!visited[next.v]) {
                        pq.add(next);
                    }
                }
            }
        }

        System.out.println(sum);
    }
}