import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //비교를 위한 가장 작은 수를 각 스택에 삽입한다.
        Deque<Integer>[] stacks = new ArrayDeque[4];
        for(int i=0; i<4; i++) {
            stacks[i] = new ArrayDeque<>();
            stacks[i].push(0);
        }

        //스택의 peek보다 큰 수라면 삽입하기
        for(int i=0; i<N; i++) {
            boolean flag = false;
            for(int j=0; j<4; j++) {
                if(stacks[j].peek() < A[i]) {
                    stacks[j].push(A[i]);
                    flag = true;
                    break;
                }
            }

            //모든 스택에 삽입하지 못 했다면
            if(!flag) {
                System.out.println("NO");
                return;
            }
        }

        //순열 청소가 완료되면
        System.out.println("YES");
    }
}
