import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] checked = new boolean[5][5];
        int cnt = 1;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (arr[k][l] == num) {
                            checked[k][l] = true;
                            if (bingo(checked)) {
                                System.out.println(cnt);
                                return;
                            }
                        }
                    }
                }
                cnt++;
            }
        }

    }

    public static boolean bingo(boolean[][] checked) {
        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (checked[i][j]) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                bingo++;
            }
        }

        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (checked[j][i]) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                bingo++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (checked[i][i]) {
                cnt++;
            }
        }
        if (cnt == 5) {
            bingo++;
        }

        cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (checked[i][4 - i]) {
                cnt++;
            }
        }
        if (cnt == 5) {
            bingo++;
        }
        
        if (bingo >= 3) {
            return true;
        }

        return false;
    }
}