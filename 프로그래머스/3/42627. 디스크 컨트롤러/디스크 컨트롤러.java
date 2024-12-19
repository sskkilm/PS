import java.util.PriorityQueue;

class Job {
    int number;
    int startTime;
    int runTime;

    public Job(int number, int startTime, int runTime) {
        this.number = number;
        this.startTime = startTime;
        this.runTime = runTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        int n = jobs.length;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((o1, o2) -> o1.startTime - o2.startTime);
        for (int i = 0; i < n; i++) {
            jobQueue.add(new Job(i, jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Job> waitingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.runTime == o2.runTime && o1.startTime == o2.startTime) {
                return o1.number - o2.number;
            }
            if (o1.runTime == o2.runTime) {
                return o1.startTime - o2.startTime;
            }
            return o1.runTime - o2.runTime;
        });

        int sum = 0;
        int curTime = 0;
        while (!jobQueue.isEmpty() || !waitingQueue.isEmpty()) {
            while (!jobQueue.isEmpty() && curTime >= jobQueue.peek().startTime) {
                waitingQueue.add(jobQueue.poll());
            }

            if (waitingQueue.isEmpty()) {
                curTime = jobQueue.peek().startTime;
                continue;
            }

            Job job = waitingQueue.poll();
            curTime += job.runTime;
            sum += curTime - job.startTime;
        }

        answer = sum / n;

        return answer;
    }
}