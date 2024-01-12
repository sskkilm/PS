import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value > max) {
                max = value;
            }
        }

        int cnt = 0;
        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value == max) {
                cnt++;
            }
        }

        if (cnt > 1) {
            System.out.println("?");
        } else {
            for (Character key : map.keySet()) {
                int value = map.get(key);
                if (value == max) {
                    System.out.println(key);
                }
            }
        }
    }
}