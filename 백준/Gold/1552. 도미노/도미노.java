import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int[][] arr;
    public static boolean[] visited;
    public static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
                if (Character.isAlphabetic(s.charAt(j))) {
                    arr[i][j] = -(Character.getNumericValue(s.charAt(j)) - 9);
                }
            }
        }

        output = new int[n];
        visited = new boolean[n];
        dfs(0);

        System.out.println(min);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculate() {
        int score = 1;

        for (int i = 0; i < n; i++) {
            score *= arr[i][output[i]];
        }

        int cycle = 0;
        boolean[] calVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!calVisited[i]) {
                cycle++;
                int cur = i;
                while (!calVisited[cur]) {
                    calVisited[cur] = true;
                    cur = output[cur];
                }
            }
        }

        if (cycle % 2 == 0) {
            score *= -1;
        }

        min = Math.min(min, score);
        max = Math.max(max, score);
    }
}