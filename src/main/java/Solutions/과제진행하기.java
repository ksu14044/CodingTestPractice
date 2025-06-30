package Solutions;


import java.util.*;

public class 과제진행하기 {
    public static class Work {
        String name; int startTime ; int restTime;
        public Work(String name, int startTime, int time){
            this.name = name;
            this.startTime = startTime;
            this.restTime = time;
        }
    }
    public static void main(String[] args) {
        String[][] plans = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };

        Arrays.sort(plans, (a, b) ->  Integer.compare(timeToMin(a[1]), timeToMin(b[1])));
        Stack<Work> paused = new Stack<>();
        List<String> answer = new ArrayList<>();

        for(int i = 0 ; i < plans.length ; i++){
            String name = plans[i][0];
            int start = timeToMin(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);

            if(i < plans.length - 1){
                int nextStart = timeToMin(plans[i+1][1]);
                int available = nextStart - start;
                if(available >= duration){
                    answer.add(name);
                    available -= duration;
                    while(!paused.isEmpty() && available > 0){
                        Work prev = paused.pop();
                        if(prev.restTime <= available){
                            answer.add(prev.name);
                        } else {
                            prev.restTime -= available;
                            paused.add(prev);
                            break;
                        }
                    }
                } else {
                    paused.add(new Work(name, start, duration - available));
                }
            } else {
                answer.add(name);
            }
        }
        while(!paused.isEmpty()){
            answer.add(paused.pop().name);
        }
        System.out.println(answer);
    }

    public static int timeToMin(String str){
        String[] st = str.split(":");
        return Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
    }
}
