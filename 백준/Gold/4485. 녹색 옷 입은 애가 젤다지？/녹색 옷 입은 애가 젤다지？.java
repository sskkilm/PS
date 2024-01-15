import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    int weight;

    public Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

public class Main {
    public static int problemNum = 1;
    public static final int INF = Integer.MAX_VALUE;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void dijkstra(int N, int[][] arr) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = INF;
            }
        }
        dist[0][0] = arr[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(0, 0, arr[0][0]));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_weight = cur.weight;

            if (dist[cur_x][cur_y] < cur_weight) {
                continue;
            }

            for (int i = 0; i < dirs.length; i++) {
                int next_x = cur_x + dirs[i][0];
                int next_y = cur_y + dirs[i][1];

                if (next_x < 0 || next_x > N - 1) {
                    continue;
                }
                if (next_y < 0 || next_y > N - 1) {
                    continue;
                }

                int cost = dist[cur_x][cur_y] + arr[next_x][next_y];
                if (cost < dist[next_x][next_y]) {
                    dist[next_x][next_y] = cost;
                    pq.add(new Node(next_x, next_y, cost));
                }
            }
        }
        System.out.printf("Problem %d: %d", problemNum, dist[N - 1][N - 1]);
        System.out.println();
        problemNum++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] arr = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(N, arr);
        }

    }
}