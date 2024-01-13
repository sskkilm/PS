import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int level = 1;
        int st = 1;
        while (st < N) {
            st += 6 * level;
            level++;
        }
        System.out.println(level);
    }
}