import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main {
    public static int[] vertex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                list.add(new Edge(i + 1, j + 1, arr[i][j]));
            }
        }
        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);

        vertex = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            vertex[i] = i;
        }

        int cnt = 0;
        long sum = 0;
        for (Edge edge : list) {
            int v1 = edge.v1;
            int v2 = edge.v2;
            int cost = edge.cost;

            int fv1 = find(v1);
            int fv2 = find(v2);
            if (fv1 != fv2) {
                union(v1, v2);
                sum += cost;
                if (cnt == N - 1) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static int find(int v) {
        if (vertex[v] == v) {
            return v;
        } else {
            return vertex[v] = find(vertex[v]);
        }
    }

    public static void union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if (fv1 != fv2) {
            vertex[fv1] = fv2;
        }
    }
}