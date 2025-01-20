class Solution {
    public static String answer;
    public static String[] d = {"d", "l", "r", "u"};
    public static int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    public static boolean flag;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";

        int dist = dist(x, y, r, c);
        if (dist > k || (dist - k) % 2 != 0) {
            return "impossible";
        }

        flag = false;
        dfs(0, "", n, m, x, y, r, c, k);

        return answer;
    }

    private int dist(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    private void dfs(int len, String s, int n, int m, int x, int y, int r, int c, int k) {
        if (flag) return;
        if (k - len < dist(x, y, r, c)) return;
        if (x == r && y == c && len == k) {
            answer = s;
            flag = true;
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];

            if (nx < 1 || nx > n) continue;
            if (ny < 1 || ny > m) continue;

            dfs(len + 1, s + d[i], n, m, nx, ny, r, c, k);
        }
    }
}