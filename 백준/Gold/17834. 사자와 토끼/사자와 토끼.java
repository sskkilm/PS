import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static List<List<Integer>> graph;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (bfs()) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int i = 1; i < visited.length; i++) {
                if (visited[i] == 1) {
                    cnt1++;
                } else if (visited[i] == -1) {
                    cnt2++;
                }
            }
            System.out.println(cnt1 * cnt2 * 2);
        } else {
            System.out.println(0);
        }

    }

    public static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        visited = new int[N + 1];
        visited[1] = 1;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = -visited[cur];
                    queue.add(next);
                } else {
                    if (visited[next] == visited[cur]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}