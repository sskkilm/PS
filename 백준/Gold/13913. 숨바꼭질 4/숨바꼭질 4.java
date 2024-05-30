import java.util.*;

public class Main {
    public static int N, K;
    public static int[] dirs = {-1, 1, 2};
    public static int[] dist;
    public static int[] parent;
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                System.out.println(dist[K]);
                break;
            }

            for (int dir : dirs) {
                int nx;
                if (dir == 2) {
                    nx = cur * 2;
                } else {
                    nx = cur + dir;
                }

                if (nx < 0 || nx > 100000) {
                    continue;
                }

                if (dist[nx] == -1 || dist[nx] == dist[cur] + 1) {
                    dist[nx] = dist[cur] + 1;
                    parent[nx] = cur;
                    queue.add(nx);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dist = new int[100001];
        Arrays.fill(dist, -1);
        parent = new int[100001];
        Arrays.fill(parent, -1);
        bfs();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(K);
        int idx = K;
        while (idx != N) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}