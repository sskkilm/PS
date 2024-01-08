import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            graph.get(v).add(new Node(to, weight));
        }

        int[] dist = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            dist[i] = INF;
        }
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node nextNode = graph.get(curNode.to).get(i);

                if (dist[nextNode.to] > curNode.weight + nextNode.weight) {
                    dist[nextNode.to] = curNode.weight + nextNode.weight;
                    pq.add(new Node(nextNode.to, dist[nextNode.to]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }


//        class Solution {
//
//        }

//        Solution s = new Solution();
//        System.out.println(s.solution());
    }
}

