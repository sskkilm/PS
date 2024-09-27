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
    public static int R, C;
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int totalV = 0;
    public static int totalK = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalK + " " + totalV);
    }

    public static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        int v = 0;
        int k = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (arr[cur.x][cur.y] == 'v') {
                v++;
            } else if (arr[cur.x][cur.y] == 'k') {
                k++;
            }

            for(int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > R - 1) continue;
                if (ny < 0 || ny > C - 1) continue;

                if (arr[nx][ny] != '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        if (v >= k) {
            k = 0;
        } else {
            v = 0;
        }

        totalV += v;
        totalK += k;
    }
}