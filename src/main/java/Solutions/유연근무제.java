package Solutions;

public class 유연근무제 {
    static int answer;
    public static void main(String[] args) {
        answer = 0;
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;
        System.out.println(solution(schedules, timelogs, startday));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday){
        for(int i = 0 ; i < timelogs.length ; i++){
            int count = 0;
            int limitTime = schedules[i] / 100 * 60 + schedules[i] % 100 + 10;
            for(int j = 0 ; j < timelogs[i].length ; j++){
                if((j + startday) % 7 == 0 || (j + startday) % 7 == 6) continue;
                int registTime = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                if(registTime <= limitTime) count++;
            }
            if(count == 5) answer++;
        }
        return answer;
    }
}
