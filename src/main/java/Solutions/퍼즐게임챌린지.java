package Solutions;

public class 퍼즐게임챌린지 {
    public static void main(String[] args) {
        int[] diffs = {1,5,3};
        int[] times = {2,4,7};
        int limit = 30;
        System.out.println(solution(diffs, times, limit));
    }
    public static int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100_000;
        int answer = right;
        while(left <= right){
            int mid = (left + right) / 2;
            long reqTime = calc(diffs, times, mid);
            if(reqTime <= limit){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static long calc(int[] diffs, int[] times, int level){
        int timePrev = 0;
        long total = 0;
        for(int i = 0 ; i < diffs.length ; i++){
            int timeCur = times[i];
            if(i > 0) timePrev = times[i-1];
            if(diffs[i] <= level){
                total += timeCur;
            } else {
                int miss = diffs[i] - level;
                total += (long)(timePrev + timeCur) * miss + timeCur;
            }
            if(total > 1_000_000_000_000_000L) break;
        }
        return total;
    }
}
