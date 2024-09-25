import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static ListIterator<Character> it;
    public static List<Character> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        it = list.listIterator();
        while(it.hasNext()) {
            it.next();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            op(strings);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void op(String[] strings) {
        switch (strings[0]) {
            case "L":
                if (it.hasPrevious()) {
                    it.previous();
                }
                break;
            case "D":
                if (it.hasNext()) {
                    it.next();
                }
                break;
            case "B":
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
                break;
            case "P":
                it.add(strings[1].charAt(0));
                break;
        }
    }
}