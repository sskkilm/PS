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
    public static int R, C;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static char[][] arr;
    public static boolean[][] visited;
    public static List<Node> list = new ArrayList<>();

    public static void bfs() {
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > R - 1) continue;
                if (ny < 0 || ny > C - 1) continue;

                if (arr[nx][ny] == '.') {
                    arr[nx][ny] = 'D';
                } else if (arr[nx][ny] == 'S') {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(1);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] tmp = sc.nextLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = tmp[j];
                if (arr[i][j] == 'W') {
                    list.add(new Node(i, j));
                }
            }
        }

        bfs();
    }
}