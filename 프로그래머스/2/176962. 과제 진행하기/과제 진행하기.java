import java.util.*;

class Task {
    String name;
    int start;
    int time;

    public Task(String name, int start, int time) {
        this.name = name;
        this.start = start;
        this.time = time;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};

        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            String[] s = plan[1].split(":");
            tasks.add(new Task(plan[0], Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(tasks, (o1, o2) -> o1.start - o2.start);

        List<String> ans = new ArrayList<>();
        Stack<Task> stack = new Stack<>();
        int time = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            while (!stack.isEmpty()) {
                Task prevTask = stack.pop();
                if (curTask.start < time + prevTask.time) {
                    stack.push(new Task(prevTask.name, prevTask.start, prevTask.time - (curTask.start - time)));
                    break;
                } else {
                    ans.add(prevTask.name);
                    time += prevTask.time;
                }
            }
            stack.push(curTask);
            time = curTask.start;
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }

        answer = ans.toArray(new String[0]);

        return answer;
    }
}