import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        if (s.equals("")) {
            System.out.println(0);
            return;
        }
        String[] tmp = s.split(" ");
        System.out.println(tmp.length);
    }
}