import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    boolean flag;

    public Node(int x, int y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }
}

public class Main {
    public static int R, C;
    public static int st_x, st_y, ed_x, ed_y;
    public static char[][] arr;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
                if (arr[i][j] == 'S') {
                    st_x = i;
                    st_y = j;
                } else if (arr[i][j] == 'D') {
                    ed_x = i;
                    ed_y = j;
                }
            }
        }

        int answer = bfs();

        if (answer == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') {
                    visited[i][j] = true;
                    queue.add(new Node(i, j, false));
                }
            }
        }

        visited[st_x][st_y] = true;
        queue.add(new Node(st_x, st_y, true));

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                int cx = cur.x;
                int cy = cur.y;
                if (cur.flag && cx == ed_x && cy == ed_y) {
                    return level;
                }

                for (int[] dir : dirs) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];

                    if (nx < 0 || nx > R - 1) continue;
                    if (ny < 0 || ny > C - 1) continue;

                    if (!cur.flag) {
                        if (arr[nx][ny] == '.' && !visited[nx][ny]) {
                            arr[nx][ny] = '*';
                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny, false));
                        }
                    } else {
                        if ((arr[nx][ny] == '.' || arr[nx][ny] == 'D') && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny, true));
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }
}