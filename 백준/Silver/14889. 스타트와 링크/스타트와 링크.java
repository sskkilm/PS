import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N, answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static int[][] arr;
    public static List<Integer> startTeam = new ArrayList<>();
    public static List<Integer> linkTeam = new ArrayList<>();

    public static void dfs(int depth, int start) {
        if (depth == N / 2) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    startTeam.add(i);
                } else {
                    linkTeam.add(i);
                }
            }
            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < startTeam.size() - 1; i++) {
                int start_i = startTeam.get(i);
                int link_i = linkTeam.get(i);
                for (int j = i + 1; j < startTeam.size(); j++) {
                    int start_j = startTeam.get(j);
                    int link_j = linkTeam.get(j);
                    startSum += (arr[start_i][start_j] + arr[start_j][start_i]);
                    linkSum += (arr[link_i][link_j] + arr[link_j][link_i]);
                }
            }
            answer = Math.min(answer, Math.abs(startSum - linkSum));
            startTeam.clear();
            linkTeam.clear();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N];
        dfs(0, 0);

        System.out.println(answer);
    }
}