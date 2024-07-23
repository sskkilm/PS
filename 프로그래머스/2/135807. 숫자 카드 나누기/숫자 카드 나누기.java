class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }

        if (check(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        if (check(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean check(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % n == 0) {
                return false;
            }
        }
        return true;
    }

}