import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Passenger {
    int st_x;
    int st_y;
    int ed_x;
    int ed_y;

    public Passenger(int st_x, int st_y, int ed_x, int ed_y) {
        this.st_x = st_x;
        this.st_y = st_y;
        this.ed_x = ed_x;
        this.ed_y = ed_y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return st_x == passenger.st_x && st_y == passenger.st_y && ed_x == passenger.ed_x && ed_y == passenger.ed_y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(st_x, st_y, ed_x, ed_y);
    }
}

class PassengerNode {
    Passenger passenger;
    int len;

    public PassengerNode(Passenger passenger, int len) {
        this.passenger = passenger;
        this.len = len;
    }
}

class Node {
    int x;
    int y;
    int num;

    public Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

class Node2 {
    int x;
    int y;
    int len;

    public Node2(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}

public class Main {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int N;
    public static int[][] arr;
    public static int taxi_x, taxi_y;
    public static List<Passenger> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi_x = Integer.parseInt(st.nextToken()) - 1;
        taxi_y = Integer.parseInt(st.nextToken()) - 1;

        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int st_x = Integer.parseInt(st.nextToken()) - 1;
            int st_y = Integer.parseInt(st.nextToken()) - 1;
            int ed_x = Integer.parseInt(st.nextToken()) - 1;
            int ed_y = Integer.parseInt(st.nextToken()) - 1;
            list.add(new Passenger(st_x, st_y, ed_x, ed_y));
        }

        for (int i = 0; i < M; i++) {

            PassengerNode passengerNode = bfs();
            if (passengerNode == null || passengerNode.len > fuel) {
                System.out.println(-1);
                return;
            }

            fuel -= passengerNode.len;

            Passenger passenger = passengerNode.passenger;
            int len = bfs2(passenger.st_x, passenger.st_y, passenger.ed_x, passenger.ed_y);
            if (len == -1 || len > fuel) {
                System.out.println(-1);
                return;
            }

            fuel += len;

            taxi_x = passenger.ed_x;
            taxi_y = passenger.ed_y;
            list.remove(passenger);
        }

        System.out.println(fuel);
    }

    private static PassengerNode bfs() {
        PriorityQueue<PassengerNode> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.len == o2.len && o1.passenger.st_x == o2.passenger.st_x) {
                return o1.passenger.st_y - o2.passenger.st_y;
            }
            if (o1.len == o2.len) {
                return o1.passenger.st_x - o2.passenger.st_x;
            }

            return o1.len - o2.len;
        });

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][N][list.size()];
        for (int i = 0; i < list.size(); i++) {
            Passenger passenger = list.get(i);
            queue.add(new Node(passenger.st_x, passenger.st_y, i));
            visited[passenger.st_x][passenger.st_y][i] = true;
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.x == taxi_x && cur.y == taxi_y) {
                    pq.add(new PassengerNode(list.get(cur.num), level));
                    continue;
                }

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || nx > N - 1) continue;
                    if (ny < 0 || ny > N - 1) continue;

                    if (arr[nx][ny] == 0 && !visited[nx][ny][cur.num]) {
                        visited[nx][ny][cur.num] = true;
                        queue.add(new Node(nx, ny, cur.num));
                    }
                }
            }
            if (!pq.isEmpty()) {
                return pq.poll();
            }
            level++;
        }

        return null;
    }

    private static int bfs2(int st_x, int st_y, int ed_x, int ed_y) {
        Queue<Node2> queue = new LinkedList<>();
        queue.add(new Node2(st_x, st_y, 0));

        boolean[][] visited = new boolean[N][N];
        visited[st_x][st_y] = true;

        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            if (cur.x == ed_x && cur.y == ed_y) {
                return cur.len;
            }

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > N - 1) continue;
                if (ny < 0 || ny > N - 1) continue;

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node2(nx, ny, cur.len + 1));
                }
            }
        }

        return -1;
    }
}