import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N.length(); i++) {
            list.add(Character.getNumericValue(N.charAt(i)));
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);

        if (list.get(list.size() - 1) != 0) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}