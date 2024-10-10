import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class TrieNode {
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }

            node = node.children.get(c);
        }
    }

    public boolean check(String s) {
        TrieNode node = root;

        for (char c : s.toCharArray()) {
            node = node.children.getOrDefault(c, null);
            if (node == null) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String prefixCandidate = br.readLine();
            if (trie.check(prefixCandidate)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}