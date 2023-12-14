import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<>();
        int cnt = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] seq = new int[M];
        for (int i = 0; i < M; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int target_idx = deque.indexOf(seq[i]);
            int half_index;

            if (deque.size()%2 == 0) {
                half_index = deque.size() / 2 - 1;
            } else {
                half_index = deque.size() / 2;
            }

            if (target_idx <= half_index) {
                for (int j = 0; j < target_idx; j++) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}