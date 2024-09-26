import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] strings = br.readLine().split(" ");
                map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
            }
            int result = 1;
            for (String key : map.keySet()) {
                result *= map.get(key) + 1;
            }
            System.out.println(result - 1);
        }
    }
}