import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int n;
    public boolean[] visited;
    public List<String> list;
    public int solution(String[][] relation) {

        list = new ArrayList<>();

        n = relation[0].length;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n];
            dfs(0, 0, i, "", relation);
        }

        return list.size();
    }

    private void dfs(int depth, int start, int r, String s, String[][] relation) {
        if (depth == r) {
            if (check(s, relation)) {
                list.add(s);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1, r, s + (i + 1), relation);
            visited[i] = false;
        }
    }

    private boolean check(String s, String[][] relation) {
        // 1. 각 튜플의 속성 조합 값을 저장할 Set
        Set<String> tupleSet = new HashSet<>();

        // 2. 속성 인덱스를 문자열 s에서 추출
        List<Integer> indices = new ArrayList<>();
        for (char c : s.toCharArray()) {
            indices.add(c - '1'); // '1'부터 시작했으므로 - '1'로 실제 인덱스 변환
        }

        // 3. 모든 튜플에 대해 속성 조합 값을 확인
        for (String[] tuple : relation) {
            StringBuilder key = new StringBuilder();
            for (int index : indices) {
                key.append(tuple[index]).append(",");
            }
            // 조합된 속성이 중복되면 유일성 위반
            if (!tupleSet.add(key.toString())) {
                return false;
            }
        }

        // 4. 최소성 확인
        for (String candidate : list) {
            int count = 0;
            for (char c : candidate.toCharArray()) {
                if (s.indexOf(c) != -1) count++;
            }
            // candidate가 s의 부분 집합이면 최소성 위반
            if (count == candidate.length()) {
                return false;
            }
        }

        return true; // 유일성 및 최소성 모두 만족
    }
}