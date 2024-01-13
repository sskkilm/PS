import java.util.*;

public class Main {
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            if (isPrime(arr[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}