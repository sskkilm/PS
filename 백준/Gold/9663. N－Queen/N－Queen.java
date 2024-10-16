import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int N, answer = 0;
    public static int[] arr;

    public int solution(int n) {

        N = n;
        arr = new int[n];

        int row = 0;
        for (int col = 0; col < n; col++) {
            arr[row] = col;
            dfs(row + 1);
        }

        return answer;
    }

    public void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (check(row, col)) {
                arr[row] = col;
                dfs(row + 1);
            }
        }
    }

    public boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col) {
                return false;
            }
            if (Math.abs(arr[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(new Solution().solution(n));
    }
}