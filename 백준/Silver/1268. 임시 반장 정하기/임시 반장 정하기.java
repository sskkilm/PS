import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        visited[j] = true;
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    cnt++;
                }
            }
            map.put(i + 1, cnt);
        }

        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        for (int i = 1; i <= N; i++) {
            if (map.get(i) == max) {
                System.out.println(i);
                return;
            }
        }
    }
}