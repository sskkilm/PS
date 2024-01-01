import java.util.*;

public class Main {
    public static boolean isPelindrom(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (sb.toString().equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        while (true ) {
            if (isPelindrom(s.substring(cnt))) {
                break;
            } else {
                cnt++;
            }
        }
        int ans = s.length() + cnt;
        System.out.println(ans);
    }
}

