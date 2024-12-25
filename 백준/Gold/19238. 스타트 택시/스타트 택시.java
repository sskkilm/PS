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
}

class PassengerInfo {
    Passenger passenger;
    int distanceFromTaxi;

    public PassengerInfo(Passenger passenger, int distanceFromTaxi) {
        this.passenger = passenger;
        this.distanceFromTaxi = distanceFromTaxi;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N;
    public static int[][] arr;
    public static int taxi_x, taxi_y;
    public static List<Passenger> passengers;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        passengers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int st_x = Integer.parseInt(st.nextToken()) - 1;
            int st_y = Integer.parseInt(st.nextToken()) - 1;
            int ed_x = Integer.parseInt(st.nextToken()) - 1;
            int ed_y = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(st_x, st_y, ed_x, ed_y));
        }

        for (int i = 0; i < M; i++) {
            PassengerInfo passengerInfo = findClosestPassengerInfo();
            if (passengerInfo == null || passengerInfo.distanceFromTaxi > fuel) {
                System.out.println(-1);
                return;
            }

            fuel -= passengerInfo.distanceFromTaxi;

            Passenger passenger = passengerInfo.passenger;
            int dist = getDistanceToEndPoint(passenger);
            if (dist == -1 || dist > fuel) {
                System.out.println(-1);
                return;
            }

            fuel += dist;

            taxi_x = passenger.ed_x;
            taxi_y = passenger.ed_y;

            passengers.remove(passenger);
        }

        System.out.println(fuel);
    }

    private static PassengerInfo findClosestPassengerInfo() {
        PriorityQueue<PassengerInfo> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.distanceFromTaxi == o2.distanceFromTaxi && o1.passenger.st_x == o2.passenger.st_x) {
                return o1.passenger.st_y - o2.passenger.st_y;
            }
            if (o1.distanceFromTaxi == o2.distanceFromTaxi) {
                return o1.passenger.st_x - o2.passenger.st_x;
            }

            return o1.distanceFromTaxi - o2.distanceFromTaxi;
        });

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(taxi_x, taxi_y));

        boolean[][] visited = new boolean[N][N];
        visited[taxi_x][taxi_y] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Passenger passenger : passengers) {
                    if (cur.x == passenger.st_x && cur.y == passenger.st_y) {
                        pq.add(new PassengerInfo(passenger, level));
                    }
                }

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || nx > N - 1) continue;
                    if (ny < 0 || ny > N - 1) continue;

                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
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

    private static int getDistanceToEndPoint(Passenger passenger) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(passenger.st_x, passenger.st_y));

        boolean[][] visited = new boolean[N][N];
        visited[passenger.st_x][passenger.st_y] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.x == passenger.ed_x && cur.y == passenger.ed_y) {
                    return level;
                }

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || nx > N - 1) continue;
                    if (ny < 0 || ny > N - 1) continue;

                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
            level++;
        }

        return -1;
    }
}