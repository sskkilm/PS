import java.util.*;

public class Main {
    public static int L, C;
    public static List<String> list = new ArrayList<>();
    public static Set<Character> set = new HashSet<>();
    public static void dfs(int depth, int start, String[] arr, String s) {
        if (depth == L) {
            if (validate(s)) {
                list.add(s);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            dfs(depth + 1, i + 1, arr, s + arr[i]);
        }
    }

    public static boolean validate(String s) {
        int cnt1 = 0;
        int cnt2 = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        if (cnt1 >= 1 && cnt2 >= 2) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        String[] arr = new String[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        dfs(0, 0, arr, "");

        for (String s : list) {
            System.out.println(s);
        }
    }
}