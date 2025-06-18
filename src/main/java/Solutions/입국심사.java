package Solutions;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n , int[] times){
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while(left <= right){
            long total = 0;
            long mid = (left + right) / 2;
            for(int time : times){
                total += mid / time;
            }
            if(total >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
