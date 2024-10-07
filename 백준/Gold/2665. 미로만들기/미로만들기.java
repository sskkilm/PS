import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

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
    public static int n;
    public static char[][] arr;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(0, 0, 0));

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.x][cur.y] < cur.weight) continue;

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 0 || nx > n - 1) continue;
                if (ny < 0 || ny > n - 1) continue;

                int nextWeight = dist[cur.x][cur.y];
                if (arr[nx][ny] == '0') {
                    nextWeight++;
                }
                if (dist[nx][ny] > nextWeight) {
                    dist[nx][ny] = nextWeight;
                    pq.add(new Node(nx, ny, nextWeight));
                }
            }
        }

        System.out.println(dist[n - 1][n - 1]);
    }
}