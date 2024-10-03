import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Result {
    int time;
    int height;

    public Result(int time, int height) {
        this.time = time;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        List<Result> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            int totalTime = 0;
            int requiredBlock = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] >= i) {
                        totalTime += (2 * (arr[j][k] - i));
                        requiredBlock -= (arr[j][k] - i);
                    } else {
                        totalTime += (i - arr[j][k]);
                        requiredBlock += (i - arr[j][k]);
                    }
                }
            }
            if (requiredBlock > B) {
                continue;
            }
            list.add(new Result(totalTime, i));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.height - o1.height;
            }
            return o1.time - o2.time;
        });

        Result result = list.get(0);
        System.out.println(result.time + " " + result.height);
    }
}