import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int cur_v = queue.poll();
            for(int next_v : adj[cur_v]) {
                if (!visited[next_v]) {
                    queue.add(next_v);
                    visited[next_v] = true;
                    parent[next_v] = cur_v;
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}