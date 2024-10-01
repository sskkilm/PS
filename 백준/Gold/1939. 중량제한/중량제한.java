import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

public class Main {
    public static List<List<Node>> graph;
    public static int N, M;
    public static int start, end;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.weight - o1.weight);
        pq.add(new Node(start, Integer.MAX_VALUE));

        int[] dist = new int[N + 1];
        dist[start] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.v] > cur.weight) continue;

            for (Node next : graph.get(cur.v)) {
                int selected = Math.min(cur.weight, next.weight);
                if (dist[next.v] < selected) {
                    dist[next.v] = selected;
                    pq.add(new Node(next.v, selected));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
