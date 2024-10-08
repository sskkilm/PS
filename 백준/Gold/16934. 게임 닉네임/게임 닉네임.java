import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> childNodes;
    boolean isTerminated;

    public TrieNode() {
        this.childNodes = new HashMap<>();
        this.isTerminated = false;
    }
}

class Trie {
    TrieNode rootNode;

    public Trie() {
        this.rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = rootNode;
        for (char ch : word.toCharArray()) {
            node = node.childNodes.computeIfAbsent(ch, key -> new TrieNode());
        }
        node.isTerminated = true;
    }

    public int searchMatchLastIndex(String word) {
        int index = -1;
        TrieNode node = rootNode;
        for (char ch : word.toCharArray()) {
            node = node.childNodes.getOrDefault(ch, null);

            if (node == null) {
                break;
            }
            index++;
        }
        return index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String nickname = br.readLine();
            map.put(nickname, map.getOrDefault(nickname, 0) + 1);

            int matchedLastIndex = trie.searchMatchLastIndex(nickname);
            if (matchedLastIndex == nickname.length() - 1) {
                int cnt = map.get(nickname);
                if (cnt == 1) {
                    System.out.println(nickname);
                } else {
                    System.out.println(nickname + cnt);
                }
            } else if (matchedLastIndex == -1) {
                System.out.println(nickname.charAt(0));
            } else {
                System.out.println(nickname.substring(0, matchedLastIndex + 2));
            }

            trie.insert(nickname);
        }
    }

}