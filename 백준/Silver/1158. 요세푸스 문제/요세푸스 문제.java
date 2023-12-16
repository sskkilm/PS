import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        StringBuilder str = new StringBuilder();
        str.append("<");
        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            str.append(queue.poll());
            str.append(", ");
        }
        str.append(queue.poll());
        str.append(">");
        System.out.println(str);
    }
}