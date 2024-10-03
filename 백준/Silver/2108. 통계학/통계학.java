import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round((double) sum / N));

        Arrays.sort(arr);
        System.out.println(arr[N / 2]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            Collections.sort(list);
            System.out.println(list.get(1));
        }

        System.out.println(arr[N - 1] - arr[0]);
    }
}