package Solutions;

import java.util.Arrays;
import java.util.PriorityQueue;


public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{3,5}};
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        System.out.println(Arrays.deepToString(jobs));
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int time = 0;
        int totalTurnArountTime = 0;
        int completedJob = 0;
        int jobIndex = 0;
        int answer =0;
        while(completedJob < jobs.length) {
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= time){
                q.offer(jobs[jobIndex]);
                jobIndex++;
            }
            if(!q.isEmpty()){
                int[] job = q.poll();
                time += job[1];
                totalTurnArountTime += (time - job[0]);
                completedJob++;
            } else {
                time = jobs[jobIndex][0];
            }
        }
        answer = totalTurnArountTime / jobs.length;
        System.out.println(answer);
    }
}
