import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int F, S, G, U, D;
    public static int[] dist;
    public static boolean[] visited;
    public static void bfs(int S) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        visited = new boolean[F + 1];
        visited[S] = true;

        dist = new int[F + 1];
        dist[S] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == G) {
                System.out.println(dist[G]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = 0;
                if (i == 0) {
                    next = cur + U;
                } else {
                    next = cur - D;
                }

                if (next < 1 || next > F) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        System.out.println("use the stairs");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        bfs(S);
    }
}