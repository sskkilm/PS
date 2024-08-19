import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int dir;
    int len;

    public Node(int x, int y, int dir, int len) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.len = len;
    }
}

public class Main {
    public static int M, N;
    public static int[][] arr;
    public static int st_x, st_y, st_d;
    public static int ed_x, ed_y, ed_d;
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String[] start = br.readLine().split(" ");
        st_x = Integer.parseInt(start[0]) - 1;
        st_y = Integer.parseInt(start[1]) - 1;
        st_d = Integer.parseInt(start[2]) - 1;

        String[] end = br.readLine().split(" ");
        ed_x = Integer.parseInt(end[0]) - 1;
        ed_y = Integer.parseInt(end[1]) - 1;
        ed_d = Integer.parseInt(end[2]) - 1;

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(st_x, st_y, st_d, 0));

        boolean[][][] visited = new boolean[M][N][4];
        visited[st_x][st_y][st_d] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == ed_x && cur.y == ed_y && cur.dir == ed_d) {
                return cur.len;
            }

            int left = 0;
            int right = 0;
            if (cur.dir == 0) {
                left = 3;
                right = 2;
            } else if (cur.dir == 1) {
                left = 2;
                right = 3;
            } else if (cur.dir == 2) {
                left = 0;
                right = 1;
            } else if (cur.dir == 3) {
                left = 1;
                right = 0;
            }

            if (!visited[cur.x][cur.y][left]) {
                visited[cur.x][cur.y][left] = true;
                queue.add(new Node(cur.x, cur.y, left, cur.len + 1));
            }
            if (!visited[cur.x][cur.y][right]) {
                visited[cur.x][cur.y][right] = true;
                queue.add(new Node(cur.x, cur.y, right, cur.len + 1));
            }

            for (int i = 1; i <= 3; i++) {
                int nx = cur.x + dirs[cur.dir][0] * i;
                int ny = cur.y + dirs[cur.dir][1] * i;

                if (nx < 0 || nx > M - 1) continue;
                if (ny < 0 || ny > N - 1) continue;

                if (arr[nx][ny] == 1) break;

                if (!visited[nx][ny][cur.dir]) {
                    visited[nx][ny][cur.dir] = true;
                    queue.add(new Node(nx, ny, cur.dir, cur.len + 1));
                }
            }
        }

        return -1;
    }
}