import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치를 저장하기 위한 node 클래스
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
        // 가로 길이
        M = Integer.parseInt(st.nextToken());
        // 세로 길이
        N = Integer.parseInt(st.nextToken());
        // 높이
        H = Integer.parseInt(st.nextToken());
        // 토마토 상태 배열
        arr = new int[H][N][M];
        // bfs를 위한 queue
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    // 토마토 상태 저장
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    // 초기 익은 토마토 위치 저장
                    if (arr[i][j][k] == 1) {
                        queue.add(new Node(j, k, i));
                    }
                }
            }
        }
        // 이미 모두 익어있다면 0 출력
        if (check(arr)) {
            System.out.println(0);
            return;
        }

        // 아니라면 bfs 탐색
        bfs();
    }

    // 안 익은 토마토가 있다면 false, 없다면 true
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
        // 해당 좌표에 도달하기 위해 걸리는 최소 일자를 저장하기 위한 배열
        int[][][] dist = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 익은 토마토에서부터 0일
                    if (arr[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                    } else if (arr[i][j][k] == 0) { // 아직 도달하지 않은 안 익은 토마토는 무한대 값
                        dist[i][j][k] = Integer.MAX_VALUE;
                    } else { // 빈 공간은 -1
                        dist[i][j][k] = -1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 6방향으로 이동
            for (int[] dir : dirs) {
                int nz = cur.z + dir[0];
                int nx = cur.x + dir[1];
                int ny = cur.y + dir[2];

                if (nz < 0 || nz > H - 1) continue;
                if (nx < 0 || nx > N - 1) continue;
                if (ny < 0 || ny > M - 1) continue;

                // 빈공간이 아니고
                if (arr[nz][nx][ny] != -1) {
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