import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int A = sc.nextInt();
        int H = sc.nextInt();

        Long ans = 1L;
        for (int i = 0; i < N - 1; i++) {
            ans = (ans * M) % 1000000007;
        }
        System.out.println(ans);
    }
}