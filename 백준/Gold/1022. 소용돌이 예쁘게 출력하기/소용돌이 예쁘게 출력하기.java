import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int row = r2 - r1 + 1;
        int col = c2 - c1 + 1;
        int size = row * col;
        int[][] arr = new int[row][col];

        int x = 0;
        int y = 0;
        if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
            arr[x - r1][y - c1] = 1;
            size--;
        }

        int i = 1;
        int num = 2;
        // 오른쪽 위 왼쪽 아래
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int dirOption = 0;
        int dirChangeCount = 0;
        int max = 0;
        while (size > 0) {
            for (int j = 0; j < i; j++) {
                x += dx[dirOption % 4];
                y += dy[dirOption % 4];
                if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                    arr[x - r1][y - c1] = num;
                    size--;
                    max = Math.max(max, arr[x - r1][y - c1]);
                }
                num++;
            }
            dirOption++;
            dirChangeCount++;
            if (dirChangeCount % 2 == 0) {
                i++;
            }
        }

        int cnt = 1;
        while (max / 10 > 0) {
            max /= 10;
            cnt++;
        }

        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                System.out.printf("%" + cnt + "d ", arr[j][k]);
            }
            System.out.println();
        }

    }
}