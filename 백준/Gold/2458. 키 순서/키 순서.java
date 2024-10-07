import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static List<List<Integer>> in;
    public static List<List<Integer>> out;
    public static int[] inCount;
    public static int[] outCount;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        out = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            out.add(new ArrayList<>());
        }
        in = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            in.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            out.get(a).add(b);
            in.get(b).add(a);
        }

        inCount = new int[N + 1];
        outCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfsIn(i);
            visited = new boolean[N + 1];
            dfsOut(i);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (inCount[i] + outCount[i] == N - 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfsIn(int v) {
        visited[v] = true;

        for (int next : out.get(v)) {
            if (!visited[next]) {
                inCount[next]++;
                dfsIn(next);
            }
        }
    }

    public static void dfsOut(int v) {
        visited[v] = true;

        for (int next : in.get(v)) {
            if (!visited[next]) {
                outCount[next]++;
                dfsOut(next);
            }
        }
    }
}