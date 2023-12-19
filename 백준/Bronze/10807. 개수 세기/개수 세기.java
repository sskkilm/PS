import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = Integer.parseInt(sc.nextLine());

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
