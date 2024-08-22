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

class Solution {
    public int[][] map;
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        map = new int[102][102];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] rec : rectangle) {
            int st_x = rec[0] * 2;
            int st_y = rec[1] * 2;
            int ed_x = rec[2] * 2;
            int ed_y = rec[3] * 2;

            for (int i = st_x; i <= ed_x; i++) {
                for (int j = st_y; j <= ed_y; j++) {
                    if (i == st_x || i == ed_x || j == st_y || j == ed_y) {
                        if (map[i][j] != 2) {
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        int cnt = bfs(characterX, characterY, itemX, itemY);

        answer = cnt / 2;

        return answer;
    }

    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(characterX, characterY, 0));

        boolean[][] visited = new boolean[102][102];
        visited[characterX][characterY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == itemX && cur.y == itemY) {
                return cur.len;
            }

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > 101) continue;
                if (ny < 0 || ny > 101) continue;

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, cur.len + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}