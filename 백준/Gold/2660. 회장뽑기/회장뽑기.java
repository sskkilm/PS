import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if (p1 == -1 && p2 == -1) {
                break;
            }

            dist[p1][p2] = 1;
            dist[p2][p1] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int score = score(dist[i]);
            minScore = Math.min(minScore, score);
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int score = score(dist[i]);
            if (score == minScore) {
                cnt++;
                list.add(i);
            }
        }

        System.out.println(minScore + " " + cnt);
        for (int candidate : list) {
            System.out.print(candidate + " ");
        }
    }

    public static int score(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}