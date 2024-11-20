class Solution {
    public int M, N, len;
    public int[][] arr;
    public boolean solution(int[][] key, int[][] lock) {

        M = key.length;
        N = lock.length;

        len = 2 * M + N - 2;
        arr = new int[len][len];
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                arr[i][j] = lock[i - M + 1][j - M + 1];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (check(key)) {
                return true;
            }
            rotate(key);
        }

        return false;
    }

    private boolean check(int[][] key) {
        for (int i = 0; i < len - M + 1; i++) {
            for (int j = 0; j < len - M + 1; j++) {

                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        arr[i + k][j + l] += key[k][l];
                    }
                }

                if (isFitted()) {
                    return true;
                }

                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        arr[i + k][j + l] -= key[k][l];
                    }
                }
            }
        }

        return false;
    }

    private boolean isFitted() {
        for (int k = M - 1; k < M - 1 + N; k++) {
            for (int l = M - 1; l < M - 1 + N; l++) {
                if (arr[k][l] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private void rotate(int[][] key) {
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                int tmp = key[i][j];
                key[i][j] = key[j][i];
                key[j][i] = tmp;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = key[i][j];
                key[i][j] = key[i][M - 1 - j];
                key[i][M - 1 - j] = tmp;
            }
        }
    }
}