import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Node {
    int v1;
    int v2;
    int cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.add(new Node(v1, v2, cost));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (Node node : list) {
                if (dist[node.v1] == INF) {
                    continue;
                }

                long tmp = dist[node.v1] + node.cost;
                if (dist[node.v2] > tmp) {
                    dist[node.v2] = tmp;

                    if (i == N) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}