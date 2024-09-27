import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int len;
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        len = (int) Math.pow(2, K);
        int[] result = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < len; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        inOrder(1);

        int[] tree = new int[len];
        for (int i = 1; i < len; i++) {
            tree[list.get(i - 1)] = result[i];
        }

        for (int i = 1; i < len; i *= 2) {
            for (int j = i; j < i * 2; j++) {
                System.out.print(tree[j] + " ");
            }
            System.out.println();
        }
    }

    public static void inOrder(int i) {
        if (i * 2 > len - 1) {
            list.add(i);
            return;
        }

        inOrder(i * 2);
        list.add(i);
        inOrder(i * 2 + 1);
    }
}