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
    public static int[][] arr;
    public static int startX, startY, endX, endY;
    public static boolean[][] visited;
    public static int[][] dirs = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            visited = new boolean[l][l];
            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == endX && cur.y == endY) {
                return cur.len;
            }

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > l - 1) continue;
                if (ny < 0 || ny > l - 1) continue;

                if (!visited[nx][ny]) {
                    queue.add(new Node(nx, ny, cur.len + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}