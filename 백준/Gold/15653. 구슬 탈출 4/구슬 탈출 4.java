import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int rx;
    int ry;
    int bx;
    int by;
    int len;

    public Node(int rx, int ry, int bx, int by, int len) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.len = len;
    }
}

public class Main {
    public static int N, M;
    public static int rx, ry, bx, by;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static char[][] arr;

    public static int[] move(int x, int y, int[] dir) {
        int nx = x;
        int ny = y;

        while (arr[nx + dir[0]][ny + dir[1]] != '#') {
            nx += dir[0];
            ny += dir[1];
            if (arr[nx][ny] == 'O') {
                return new int[]{nx, ny};
            }
        }

        return new int[]{nx, ny};
    }
    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(rx, ry, bx, by, 0));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (arr[cur.rx][cur.ry] == 'O') {
                System.out.println(cur.len);
                return;
            }

            for (int[] dir : dirs) {
                int[] nr = move(cur.rx, cur.ry, dir);
                int[] nb = move(cur.bx, cur.by, dir);

                if (arr[nb[0]][nb[1]] == 'O') {
                    continue;
                }

                if (nr[0] == nb[0] && nr[1] == nb[1]) {
                    if (dir[0] == -1) {
                        if (cur.rx < cur.bx) {
                            nb[0] += 1;
                        } else {
                            nr[0] += 1;
                        }
                    } else if (dir[0] == 1) {
                        if (cur.rx < cur.bx) {
                            nr[0] -= 1;
                        } else {
                            nb[0] -= 1;
                        }
                    } else if (dir[1] == -1) {
                        if (cur.ry < cur.by) {
                            nb[1] += 1;
                        } else {
                            nr[1] += 1;
                        }
                    } else if (dir[1] == 1) {
                        if (cur.ry < cur.by) {
                            nr[1] -= 1;
                        } else {
                            nb[1] -= 1;
                        }
                    }
                }

                if (!visited[nr[0]][nr[1]][nb[0]][nb[1]]) {
                    visited[nr[0]][nr[1]][nb[0]][nb[1]] = true;
                    queue.add(new Node(nr[0], nr[1], nb[0], nb[1], cur.len + 1));
                }
            }
        }

        System.out.println(-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] tmp = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp[j];
                if (arr[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (arr[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        bfs();
    }
}