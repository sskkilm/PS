import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Volunteer {
    int documentScore;
    int interviewScore;

    public Volunteer(int documentScore, int interviewScore) {
        this.documentScore = documentScore;
        this.interviewScore = interviewScore;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Volunteer> volunteers = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int documentScore = Integer.parseInt(st.nextToken());
                int interviewScore = Integer.parseInt(st.nextToken());
                volunteers.add(new Volunteer(documentScore, interviewScore));
            }
            Collections.sort(volunteers, (o1, o2) -> o2.documentScore - o1.documentScore);

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int cnt = 0;
            for (Volunteer volunteer : volunteers) {
                while(!pq.isEmpty() && volunteer.interviewScore < pq.peek()) {
                    pq.poll();
                    cnt++;
                }
                pq.add(volunteer.interviewScore);
            }

            System.out.println(N - cnt);
        }
    }
}