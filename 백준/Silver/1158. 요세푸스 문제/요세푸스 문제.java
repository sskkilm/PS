import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}