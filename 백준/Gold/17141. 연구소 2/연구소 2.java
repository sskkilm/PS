import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static List<Node> nodes = new ArrayList<>();
    public static boolean[] visited;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    nodes.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[nodes.size()];
        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            bfs();
            return;
        }

        for (int i = start; i < nodes.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (visited[i]) {
                queue.add(nodes.get(i));
            }
        }

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }
        for (Node node : queue) {
            dist[node.x][node.y] = 0;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx < 0 || nx > N - 1) continue;
                if (ny < 0 || ny > N - 1) continue;

                if (arr[nx][ny] != 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 1 && dist[i][j] == -1) {
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }

        answer = Math.min(answer, max);
    }
}