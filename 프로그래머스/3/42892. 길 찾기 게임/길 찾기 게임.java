import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int idx;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Tree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node tmp = root;
        while (true) {
            if (node.x > tmp.x) {
                if (tmp.right == null) {
                    tmp.right = node;
                    break;
                }
                tmp = tmp.right;
            }
            if (node.x < tmp.x) {
                if (tmp.left == null) {
                    tmp.left = node;
                    break;
                }
                tmp = tmp.left;
            }
        }
    }

    public void preorderAndSave(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }

        result.add(root.idx);
        preorderAndSave(result, root.left);
        preorderAndSave(result, root.right);
    }

    public void postorderAndSave(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }

        postorderAndSave(result, root.left);
        postorderAndSave(result, root.right);
        result.add(root.idx);
    }
}

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            int idx = i + 1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            list.add(new Node(idx, x, y));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o2.y == o1.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Tree tree = new Tree();
        for (Node node : list) {
            tree.add(node);
        }

        List<Integer> preorderResult = new ArrayList<>();
        tree.preorderAndSave(preorderResult, tree.root);

        List<Integer> postorderResult = new ArrayList<>();
        tree.postorderAndSave(postorderResult, tree.root);

        int[] result1 = preorderResult.stream()
                .mapToInt(i -> i)
                .toArray();
        int[] result2 = postorderResult.stream()
                .mapToInt(i -> i)
                .toArray();

        return new int[][]{result1, result2};
    }
}