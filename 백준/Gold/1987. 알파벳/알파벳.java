import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int R, C, answer = 0;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void dfs(int x, int y, char[][] arr, Set<Character> set, int cnt) {
        set.add(arr[x][y]);
        cnt++;
        answer = Math.max(answer, cnt);

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx > R - 1) continue;
            if (ny < 0 || ny > C - 1) continue;

            if (!set.contains(arr[nx][ny])) {
                dfs(nx, ny, arr, set, cnt);
                set.remove(arr[nx][ny]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        dfs(0, 0, arr, new HashSet<>(), 0);

        System.out.println(answer);
    }
}