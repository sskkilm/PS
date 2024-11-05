import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int len;

    public Node(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}

public class Main {
    public static int l;
    public static int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int st_x = Integer.parseInt(st.nextToken());
            int st_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ed_x = Integer.parseInt(st.nextToken());
            int ed_y = Integer.parseInt(st.nextToken());

            bfs(st_x, st_y, ed_x, ed_y);
        }
    }

    public static void bfs(int st_x, int st_y, int ed_x, int ed_y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(st_x, st_y, 0));

        boolean[][] visited = new boolean[l][l];
        visited[st_x][st_y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == ed_x && cur.y == ed_y) {
                System.out.println(cur.len);
                return;
            }

            for (int[] dir : dirs) {
                int nx = dir[0] + cur.x;
                int ny = dir[1] + cur.y;

                if (nx < 0 || nx > l - 1) continue;
                if (ny < 0 || ny > l - 1) continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, cur.len + 1));
                }
            }
        }

    }
}