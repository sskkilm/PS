import java.util.*;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Robot {
    Pos p1;
    Pos p2;

    public Robot(Pos p1, Pos p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(p1, robot.p1) && Objects.equals(p2, robot.p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }
}

class Solution {
    public int N;
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] board) {

        N = board.length;

        return bfs(board);
    }

    private int bfs(int[][] board) {
        Queue<Robot> queue = new LinkedList<>();
        Robot robot = new Robot(new Pos(0, 0), new Pos(0, 1));
        queue.add(robot);

        Set<Robot> visited = new HashSet<>();
        visited.add(robot);

        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Robot cur = queue.poll();
                if ((cur.p1.x == N - 1 && cur.p1.y == N - 1) || (cur.p2.x == N - 1 && cur.p2.y == N - 1)) {
                    return time;
                }

                move(queue, visited, cur, board); // 이동
                rotate(queue, visited, cur, board); // 회전
            }
            time++;
        }

        return -1;
    }

    private void move(Queue<Robot> queue, Set<Robot> visited, Robot cur, int[][] board) {
        for (int[] dir : dirs) {
            int nx1 = cur.p1.x + dir[0];
            int ny1 = cur.p1.y + dir[1];
            int nx2 = cur.p2.x + dir[0];
            int ny2 = cur.p2.y + dir[1];

            if (isValid(nx1, ny1, board) && isValid(nx2, ny2, board)) {
                Robot next = new Robot(new Pos(nx1, ny1), new Pos(nx2, ny2));
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] board) {
        return x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 0;
    }

    private void rotate(Queue<Robot> queue, Set<Robot> visited, Robot cur, int[][] board) {
        if (cur.p1.x == cur.p2.x) { // 가로 상태
            int row = cur.p1.x;
            for (int d : new int[]{-1, 1}) { // 위(-1), 아래(+1)
                int newRow = row + d;
                if (isValid(newRow, cur.p1.y, board) && isValid(newRow, cur.p2.y, board)) {
                    Robot next1 = new Robot(new Pos(newRow, cur.p1.y), cur.p1);
                    Robot next2 = new Robot(new Pos(newRow, cur.p2.y), cur.p2);
                    addIfNotVisited(queue, visited, next1);
                    addIfNotVisited(queue, visited, next2);
                }
            }
        } else if (cur.p1.y == cur.p2.y) { // 세로 상태
            int col = cur.p1.y;
            for (int d : new int[]{-1, 1}) { // 왼쪽(-1), 오른쪽(+1)
                int newCol = col + d;
                if (isValid(cur.p1.x, newCol, board) && isValid(cur.p2.x, newCol, board)) {
                    Robot next1 = new Robot(new Pos(cur.p1.x, newCol), cur.p1);
                    Robot next2 = new Robot(new Pos(cur.p2.x, newCol), cur.p2);
                    addIfNotVisited(queue, visited, next1);
                    addIfNotVisited(queue, visited, next2);
                }
            }
        }
    }

    private void addIfNotVisited(Queue<Robot> queue, Set<Robot> visited, Robot robot) {
        if (!visited.contains(robot)) {
            visited.add(robot);
            queue.offer(robot);
        }
    }
}