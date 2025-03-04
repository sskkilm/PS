class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int lt = 1;
        for (int i = 0; i < stations.length; i++) {
            int rt = stations[i] - w - 1;
            if (rt < lt) {
                lt = stations[i] + w + 1;
                continue;
            }

            int len = rt - lt + 1;

            int cnt;
            int chunk = 2 * w + 1;
            if (len % chunk == 0) {
                cnt = len / chunk;
            } else {
                cnt = len / chunk + 1;
            }

            answer += cnt;

            lt = stations[i] + w + 1;
        }

        if (lt <= n) {
            int len = n - lt + 1;

            int cnt;
            int chunk = 2 * w + 1;
            if (len % chunk == 0) {
                cnt = len / chunk;
            } else {
                cnt = len / chunk + 1;
            }

            answer += cnt;
        }

        return answer;
    }
}