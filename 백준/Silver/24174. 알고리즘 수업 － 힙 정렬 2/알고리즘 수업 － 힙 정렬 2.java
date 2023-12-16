import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        StringTokenizer arrSt = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(arrSt.nextToken());
        System.out.println(new Solution(arr, K).solution());
    }

    static class Solution {
        int count = 0;
        int K;

        int[] arr;

        public Solution(int[] arr, int K) {
            this.arr = arr;
            this.K = K;
        }

        public String solution() {
            try {
                heap_sort(arr);
            } catch (Exception e) {
                return toString();
            }
            return "-1";
        }

        private void heap_sort(int[] arr) {
            int n = arr.length - 1;
            buildMinHeap(arr, n);
            for(int i = n; i >= 2; i--) {
                swap(arr, 1, i);
                heapify(arr, 1, i - 1);
            }
        }

        private void buildMinHeap(int[] arr, int n) {
            for(int i = n/2; i >= 1; i--) heapify(arr, i, n);
        }

        private void heapify(int[] arr, int k, int n) {
            int left = 2 * k;
            int right = left + 1;
            int smaller = 0;
            if(right <= n) {
                if(arr[left] < arr[right]) smaller = left;
                else smaller = right;
            } else if (left <= n) {
                smaller = left;
            } else {
                return;
            }
            if(arr[smaller] < arr[k]) {
                swap(arr, smaller, k);
                heapify(arr, smaller, n);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            if(++count == K) throw new RuntimeException();
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 1; i < arr.length; i++) sj.add(Integer.toString(arr[i]));
            return sj.toString();
        }
    }
}