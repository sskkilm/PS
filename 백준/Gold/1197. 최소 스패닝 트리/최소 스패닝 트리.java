import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {
    int v1;
    int v2;
    int cost;

    public Node(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main {
    public static int[] arr;
    public static int find(int v) {
        if (v == arr[v]) {
            return v;
        } else {
            arr[v] = find(arr[v]);
            return arr[v];
        }
    }

    public static void union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);

        if (fv1 != fv2) {
            arr[fv1] = fv2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.add(new Node(v1, v2, cost));
        }
        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);

        arr = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = i;
        }

        int cnt = 0;
        int sum = 0;
        for (Node node : list) {
            int fv1 = find(node.v1);
            int fv2 = find(node.v2);

            if (fv1 != fv2) {
                union(fv1, fv2);
                sum += node.cost;
                cnt++;
                if (cnt == V - 1) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}