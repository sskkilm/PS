import java.util.Scanner;

public class Main {
    public static int cnt1 = 0, cnt2 = 0, cnt3 = 0;
    public static int[][] arr;

    public static boolean check(int x, int y, int len) {
        int ct1 = 0;
        int ct2 = 0;
        int ct3 = 0;

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] == -1) {
                    ct1++;
                } else if (arr[i][j] == 0) {
                    ct2++;
                } else if (arr[i][j] == 1) {
                    ct3++;
                }
            }
        }

        if (ct1 == len * len || ct2 == len * len || ct3 == len * len) {
            return true;
        }

        return false;
    }
    public static void dfs(int x, int y, int len) {
        if (check(x, y, len)) {
            if (arr[x][y] == -1) {
                cnt1++;
            } else if (arr[x][y] == 0) {
                cnt2++;
            } else if (arr[x][y] == 1) {
                cnt3++;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(x + (len / 3) * i, y + (len / 3) * j, len / 3);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, N);

        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
    }
}