import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size() - 1; i++) {
            arr[i] = list.get(i + 1) - list.get(i);
        }
        Arrays.sort(arr);
        
        int sum = 0;
        for (int i = 0; i < list.size() - (K - 1); i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}