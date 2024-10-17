import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static int N;
    public static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);
        }
    }

    public static void bfs(int a, int b) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        boolean[] visited = new boolean[N + 1];
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.v == b) {
                System.out.println(cur.cost);
                return;
            }

            for (Node next : graph.get(cur.v)) {
                if (!visited[next.v]) {
                    queue.add(new Node(next.v, cur.cost + next.cost));
                    visited[next.v] = true;
                }
            }
        }
    }
}