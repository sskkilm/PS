import java.util.*;

class Node {
    int cur;
    String path;

    public Node(int cur, String path) {
        this.cur = cur;
        this.path = path;
    }
}

public class Main {
    public static String[] arr = {"D", "S", "L", "R"};
    public static boolean[] visited;
    public static int register(int cur, String s) {
        if (s.equals("D")) {
            cur *= 2;
            if (cur > 9999) {
                cur %= 10000;
            }
            return cur;
        }
        if (s.equals("S")) {
            cur -= 1;
            if (cur == -1) {
                cur = 9999;
            }
            return cur;
        }
        if (s.equals("L")) {
            int a = cur / 1000;
            int b = cur % 1000;

            return 10 * b + a;
        }
        if (s.equals("R")) {
            int a = cur / 10;
            int b = cur % 10;

            return 1000 * b + a;
        }

        return 0;
    }

    public static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, ""));
        visited = new boolean[10000];
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.cur;
            String path = node.path;
            if (cur == b) {
                System.out.println(path);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int next = register(cur, arr[i]);
                if (!visited[next]) {
                    queue.add(new Node(next, path + arr[i]));
                    visited[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            bfs(a, b);
        }
    }
}