import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	public int cnt, row, col;
	public int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public boolean[][] visited;
	public Set<Integer> set;

	public void bfs(int x, int y, int[][] land) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			cnt++;
			set.add(node.y);

			for (int[] dir : dirs) {
				int nx = node.x + dir[0];
				int ny = node.y + dir[1];

				if (nx < 0 || nx > row - 1)
					continue;
				if (ny < 0 || ny > col - 1)
					continue;

				if (land[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}
	}

	public int solution(int[][] land) {
		int answer = 0;

		row = land.length;
		col = land[0].length;

		visited = new boolean[row][col];
		int[] arr = new int[col];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (land[j][i] == 1 && !visited[j][i]) {
					set = new HashSet<>();
					cnt = 0;
					bfs(j, i, land);
					for (int tmp : set) {
						arr[tmp] += cnt;
					}
				}
			}
		}
		
		for (int i = 0; i < col; i++) {
			answer = Math.max(answer, arr[i]);
		}

		return answer;
	}
}