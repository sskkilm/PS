import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
    public static char[][] arr;
    public static int startX, startY, endX, endY;
    public static boolean[][] visited;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'B') {
                    startX = i;
                    startY = j;
                } else if (arr[i][j] == 'L') {
                    endX = i;
                    endY = j;
                }
            }
        }

        visited = new boolean[10][10];
        System.out.println(bfs() - 1);
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

                if (nx < 0 || nx > 9) continue;
                if (ny < 0 || ny > 9) continue;

                if (arr[nx][ny] != 'R' && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, cur.len + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}