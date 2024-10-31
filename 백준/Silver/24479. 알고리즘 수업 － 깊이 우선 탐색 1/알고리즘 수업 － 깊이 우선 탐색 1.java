import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int v1;
    int v2;

    public Edge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}

public class Main {
    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static int[] order;
    public static int sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.add(new Edge(v1, v2));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.v1 == o2.v1) {
                return o1.v2 - o2.v2;
            }
            return o1.v1 - o2.v1;
        });

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (Edge edge : list) {
            graph.get(edge.v1).add(edge.v2);
            graph.get(edge.v2).add(edge.v1);
        }

        visited = new boolean[N + 1];
        order = new int[N + 1];
        sequence = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    public static void dfs(int v) {
        visited[v] = true;
        order[v] = sequence++;

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}