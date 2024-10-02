import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        // 학점
        double score = 0.0;
        // 학점 × 과목평점
        double total = 0.0;

        for (int i = 0; i < 20; i++) {
            String[] result = br.readLine().split(" ");
            if (result[2].equals("P")) {
                continue;
            }
            score += Double.parseDouble(result[1]);
            total += Double.parseDouble(result[1]) * map.get(result[2]);
        }

        System.out.println(total / score);
    }
}