import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, K, X;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        List<Integer> result = bfs();
        if (result == null) {
            System.out.println(-1);
        } else {
            for (int v : result) {
                System.out.println(v);
            }
        }
    }

    public static List<Integer> bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while (!queue.isEmpty()) {
            Integer curV = queue.poll();

            for (int nextV : graph.get(curV)) {
                if (dist[nextV] > dist[curV] + 1) {
                    queue.add(nextV);
                    dist[nextV] = dist[curV] + 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}