import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = null;
        while (true) {
            String key = sc.nextLine();
            if (key.equals("0")) {
                break;
            }
            sb = new StringBuilder(key);
            sb.reverse();
            if (key.equals(sb.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}