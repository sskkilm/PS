import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int z;

    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    public static int M, N, H;
    public static int[][][] arr;
    public static Queue<Node> queue;
    public static int[][] dirs = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.add(new Node(j, k, i));
                    }
                }
            }
        }
        if (check(arr)) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static boolean check(int[][][] arr) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void bfs() {
        int[][][] dist = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                    } else if (arr[i][j][k] == 0) {
                        dist[i][j][k] = Integer.MAX_VALUE;
                    } else {
                        dist[i][j][k] = -1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int[] dir : dirs) {
                int nz = cur.z + dir[0];
                int nx = cur.x + dir[1];
                int ny = cur.y + dir[2];

                if (nz < 0 || nz > H - 1) continue;
                if (nx < 0 || nx > N - 1) continue;
                if (ny < 0 || ny > M - 1) continue;

                if (arr[nz][nx][ny] != -1 && dist[nz][nx][ny] != -1) {
                    if (dist[nz][nx][ny] > dist[cur.z][cur.x][cur.y] + 1) {
                        queue.add(new Node(nx, ny, nz));
                        dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }

        if (max == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }
}