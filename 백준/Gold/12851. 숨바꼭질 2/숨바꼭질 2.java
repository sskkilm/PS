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

        if (N == K) {
            cnt = 1;
            return;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int dir : dirs) {
                int next;
                if (dir == 2) {
                    next = cur * 2;
                } else {
                    next = cur + dir;
                }

                if (next < 0 || next > 100000) continue;
                if (dist[next] != 0 && dist[next] < dist[cur] + 1) continue;

                dist[next] = dist[cur] + 1;
                queue.add(next);

                if (next == K) {
                    cnt++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dist = new int[100001];
        bfs();

        System.out.println(dist[K]);
        System.out.println(cnt);
    }
}