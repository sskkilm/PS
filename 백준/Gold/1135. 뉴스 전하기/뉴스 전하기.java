import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] tree;
    public static int[] dp;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                continue;
            }

            tree[parent].add(i);
        }

        dp = new int[N];
        Arrays.fill(dp, -1);

        int min = dfs(0);
        System.out.println(min);
    }

    public static int dfs(int root) {
        if (tree[root].isEmpty()) {
            return dp[root] = 0;
        }

        if (dp[root] == -1) {
            List<Integer> list = tree[root];
            Collections.sort(list, (o1, o2) -> dfs(o2) - dfs(o1));

            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                max = Math.max(max, dfs(list.get(i)) + (i + 1));
            }

            dp[root] = max;
        }

        return dp[root];
    }
}