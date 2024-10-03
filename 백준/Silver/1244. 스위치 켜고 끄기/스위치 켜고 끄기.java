import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int switchCount;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        switchCount = Integer.parseInt(br.readLine());
        arr = new int[switchCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int idx = switchNumber - 1;
                while (idx < switchCount) {
                    turn(idx);
                    idx += switchNumber;
                }
            } else {
                int idx = switchNumber - 1;
                int left = idx;
                int right = idx;
                while (left >= 0 && right < switchCount) {
                    if (arr[left] == arr[right]) {
                        if (left == right) {
                            turn(left);
                        } else {
                            turn(left);
                            turn(right);
                        }
                        left -= 1;
                        right += 1;
                    } else {
                        break;
                    }
                }
            }
        }

        int a = switchCount / 20;
        if (a == 0) {
            for (int i = 0; i < switchCount; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int b = switchCount % 20;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(arr[j + 20 * i] + " ");
            }
            System.out.println();
        }
        for (int i = 20 * a; i < 20 * a + b; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void turn(int i) {
        if (arr[i] == 1) {
            arr[i] = 0;
        } else {
            arr[i] = 1;
        }
    }
}