import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int row, col, cnt;
	public int[][] arr;
	public boolean[][] visited;
	public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public void dfs(int x, int y) {
		visited[x][y] = true;
		cnt += arr[x][y];
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (nx < 0 || nx > row -1) {
				continue;
			}
			if (ny < 0 || ny > col -1) {
				continue;
			}
			
			if (arr[nx][ny] != 0 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        row = maps.length;
        col = maps[0].length();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (maps[i].charAt(j) == 'X') {
        			arr[i][j] = 0;
        		} else {
        			arr[i][j] = maps[i].charAt(j) - '0';
        		}
        	}
        }
        
        List<Integer> list = new ArrayList<>();
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] != 0 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
        Collections.sort(list);
        
        if (list.size() == 0) {
        	return new int[] {-1};
        }
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}