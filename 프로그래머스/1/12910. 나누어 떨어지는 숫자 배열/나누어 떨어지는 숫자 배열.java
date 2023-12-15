class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) {
                cnt++;
            }
        }
        if (cnt == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[cnt];
        int k = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[k] = arr[i];
                k++;
            }
        }
        
        for (int i=0; i<answer.length-1; i++) {
            for (int j=i+1; j<answer.length; j++) {
                if (answer[i] > answer[j]) {
                    int tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
            }
        }
        return answer;
    }
}