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
    int cnt;

    public Node(int x, int y, int len, int cnt) {
        this.x = x;
        this.y = y;
        this.len = len;
        this.cnt = cnt;
    }

}

public class Main {
    public static int N, M;
    public static int st_x, st_y, ed_x, ed_y;
    public static int[][] arr;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        st_x = Integer.parseInt(st.nextToken()) - 1;
        st_y = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        ed_x = Integer.parseInt(st.nextToken()) - 1;
        ed_y = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(st_x, st_y, 0, 0));

        boolean[][][] visited = new boolean[N][M][2];
        visited[st_x][st_y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int len = cur.len;
            int cnt = cur.cnt;
            if (cx == ed_x && cy == ed_y) {
                return len;
            }

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx < 0 || nx > N - 1) continue;
                if (ny < 0 || ny > M - 1) continue;

                if (arr[nx][ny] == 0 && !visited[nx][ny][cnt]) {
                    visited[nx][ny][cnt] = true;
                    queue.add(new Node(nx, ny, len + 1, cnt));
                } else if (arr[nx][ny] == 1 && cnt == 0 && !visited[nx][ny][cnt + 1]) {
                    visited[nx][ny][cnt + 1] = true;
                    queue.add(new Node(nx, ny, len + 1, cnt + 1));
                }
            }
        }

        return -1;
    }
}