import java.util.HashSet;
import java.util.Set;

class Solution {
    public int k;
    public boolean[] visited;
    public String[] nums;
    public String[] output;
    public Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        nums = numbers.split("");
        for (int i = 1; i <= numbers.length(); i++) {
            k = i;
            visited = new boolean[nums.length];
            output = new String[nums.length];
            dfs(0);
        }
        int cnt = 0;
        for (int num : set) {
            if (isPrime(num)) {
                cnt++;
            }
        }
        answer = cnt;

        return answer;
    }

    public void dfs(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                if (output[i] == null) break;
                sb.append(output[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}