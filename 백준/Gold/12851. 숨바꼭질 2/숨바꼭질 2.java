import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N, K, cnt = 0;
    public static int[] dist;
    public static int[] dirs = {-1, 1, 2};
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                cnt++;
            }

            for (int dir : dirs) {
                int next;
                if (dir == 2) {
                    next = cur * 2;
                } else {
                    next = cur + dir;
                }

                if (next < 0 || next > 100000) continue;

                if (dist[next] == -1 || dist[next] == dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        dist = new int[100001];
        Arrays.fill(dist, -1);
        bfs();

        System.out.println(dist[K]);
        System.out.println(cnt);
    }
}