import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        for (int rt = 0; rt < N; rt++) {
            int cnt = map.getOrDefault(arr[rt], 0);
            if (cnt >= M) {
                while (map.get(arr[rt]) >= M) {
                    map.put(arr[lt], map.getOrDefault(arr[lt], 1) - 1);
                    lt++;
                }
                map.put(arr[rt], map.get(arr[rt]) + 1);
            } else {
                map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            }
            max = Math.max(max, rt - lt + 1);
        }

        System.out.println(max);
    }
}