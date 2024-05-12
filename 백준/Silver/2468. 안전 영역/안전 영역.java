import java.util.Scanner;

public class Main {
	public static int N, max, cnt, answer = 0;
	public static int[][] arr;
	public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static boolean[][] visited;
	public static void dfs(int x, int y, int height) {
		visited[x][y] = true;
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (nx < 0 || nx > N - 1) continue;
			if (ny < 0 || ny > N - 1) continue;
			
			if (arr[nx][ny] > height && !visited[nx][ny]) {
				dfs(nx, ny, height);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for (int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] > i && !visited[j][k]) {
						cnt++;
						dfs(j, k, i);
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}
}
