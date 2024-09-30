import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        visited = new boolean[V + 1];
        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int v) {
        visited[v] = true;
        cnt++;

        for (int nv : graph.get(v)) {
            if (!visited[nv]) {
                dfs(nv);
            }
        }
    }
}