package Solutions;

public class 선입선출스케줄링 {
    public static void main(String[] args) {
        int n = 6;
        int[] cores = {1,2,3};
        System.out.println(solution(n, cores));
    }
    public static int solution(int n, int[] cores){
        if(n <= cores.length) return n;
        int answer = 0;
        int left = 1;
        int right = 50000;
        int time = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int workDone = cores.length;
            for(int core : cores){
                workDone += mid / core;
            }
            if(workDone >= n){
                time = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        int finished = cores.length;
        for(int core : cores){
            finished += (time - 1) / core;
        }

        for(int i = 0 ; i < cores.length ; i++){
            if(time % cores[i] == 0){
                finished++;
                if(finished == n){
                    answer = i+1;
                    break;
                }
            }
        }
        return answer;
    }

}
