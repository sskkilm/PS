import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int rx;
    int ry;
    int bx;
    int by;

    public Position(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }
}

public class Main {
    public static int N, M;
    public static int red_x, red_y, blue_x, blue_y, hole_x, hole_y;
    public static char[][] arr;
    public static boolean[][][][] visited;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[] move(int x, int y, int[] dir) {

        while (arr[x + dir[0]][y + dir[1]] != '#') {
            x += dir[0];
            y += dir[1];
            if (x == hole_x && y == hole_y) {
                break;
            }
        }

        return new int[]{x, y};
    }

    public static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(red_x, red_y, blue_x, blue_y));
        visited[red_x][red_y][blue_x][blue_y] = true;

        int cnt = 0;
        while (!queue.isEmpty() && cnt < 10) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Position cur = queue.poll();

                for (int[] dir : dirs) {
                    int[] nr = move(cur.rx, cur.ry, dir);
                    int[] nb = move(cur.bx, cur.by, dir);
                    if (nb[0] == hole_x && nb[1] == hole_y) {
                        continue;
                    }
                    if (nr[0] == hole_x && nr[1] == hole_y) {
                        System.out.println(1);
                        return;
                    }

                    if (nr[0] == nb[0] && nr[1] == nb[1]) {
                        if (dir[0] == -1) {
                            if (cur.rx < cur.bx) {
                                nb[0] += 1;
                            } else {
                                nr[0] += 1;
                            }
                        } else if (dir[0] == 1) {
                            if (cur.rx > cur.bx) {
                                nb[0] -= 1;
                            } else {
                                nr[0] -= 1;
                            }
                        } else if (dir[1] == -1) {
                            if (cur.ry < cur.by) {
                                nb[1] += 1;
                            } else {
                                nr[1] += 1;
                            }
                        } else if (dir[1] == 1) {
                            if (cur.ry > cur.by) {
                                nb[1] -= 1;
                            } else {
                                nr[1] -= 1;
                            }
                        }
                    }

                    if (!visited[nr[0]][nr[1]][nb[0]][nb[1]]) {
                        visited[nr[0]][nr[1]][nb[0]][nb[1]] = true;
                        queue.add(new Position(nr[0], nr[1], nb[0], nb[1]));
                    }
                }
            }
            cnt++;
        }

        System.out.println(0);
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
                    red_x = i;
                    red_y = j;
                } else if (arr[i][j] == 'B') {
                    blue_x = i;
                    blue_y = j;
                } else if (arr[i][j] == 'O') {
                    hole_x = i;
                    hole_y = j;
                }
            }
        }

        visited = new boolean[N][M][N][M];
        bfs();
    }
}