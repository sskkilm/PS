import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, K;
    public static int[] dirs = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        Set<Integer> visited = new HashSet<>();
        visited.add(N);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                if (cur == K) {
                    System.out.println(level);
                    return;
                }

                for (int dir : dirs) {
                    int nx;
                    if (dir == 2) {
                        nx = cur * dir;
                    } else {
                        nx = cur + dir;
                    }

                    if (nx < 0 || nx > 100000) continue;

                    if (!visited.contains(nx)) {
                        queue.add(nx);
                        visited.add(nx);
                    }
                }
            }
            level++;
        }
    }
}