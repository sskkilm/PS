import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\.");
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            System.out.println(s + " " + map.get(s));
        }
    }
}