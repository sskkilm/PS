import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Queue<Character> queue = new LinkedList<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 여는 태그를 만났을 때
            if (c == '<') {
                // 전에 stack에 저장된 내용 꺼내서 정답 문자열에 추가
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                // 닫는 괄호를 만날 때 까지 queue에 문자 저장
                while (s.charAt(i) != '>') {
                    queue.add(s.charAt(i));
                    i++;
                }
                // 다음 i가 '>'의 인덱스가 되도록 하나 줄이기
                i--;
            } else if (c == '>') { // 닫는 태그를 만났을 때
                // queue에 저장된 내용 꺼내서 정답 문자열에 추가
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                sb.append(">");
            } else { // 단어일 때
                if (c == ' ') { // 공백이면 전에 stack에 저장된 내용 꺼내서 정답 문자열에 추가
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else { // 공백이 아니면 stack에 저장
                    stack.push(c);
                }
            }
        }

        // stack에 남아있는 내용 정답 문자열에 추가
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}