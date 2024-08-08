import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int W, H;
    public static int[][] arr;
    public static int[][] odd = {{-1, 0}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    public static int[][] even = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        boolean[][] visited = new boolean[H + 2][W + 2];
        visited[0][0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 6; i++) {
                int nx;
                int ny;
                if (cx % 2 != 0) {
                    nx = cx + odd[i][0];
                    ny = cy + odd[i][1];
                } else {
                    nx = cx + even[i][0];
                    ny = cy + even[i][1];
                }

                if (nx < 0 || nx > H + 1) continue;
                if (ny < 0 || ny > W + 1) continue;

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
                if (arr[nx][ny] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}