import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int[][] arr;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static Set<String> set = new HashSet<>();
    public static void dfs(int x, int y, int depth, String s) {
        if (depth == 5) {
            set.add(s);
            return;
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > 4) {
                continue;
            }
            if (ny < 0 || ny > 4) {
                continue;
            }

            dfs(nx, ny, depth + 1, s + arr[nx][ny]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "" + arr[i][j]);
            }
        }

        System.out.println(set.size());
    }
}