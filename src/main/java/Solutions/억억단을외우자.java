package Solutions;

import java.util.Arrays;

public class 억억단을외우자 {
    public static void main(String[] args) {
        int e = 8;
        int[] starts = {1,3,7};
        System.out.println(Arrays.toString(solution(e, starts)));
    }

    public static int[] solution(int e, int[] starts){
        int[] count = new int[e + 1];
        for(int i = 1 ; i <= e ; i++){
            for(int j = i ; j <= e ; j += i){
                count[j]++;
            }
        }
        int[] best = new int[e + 1];
        int maxVal = 0;
        int maxIdx = 0;
        for(int i = e ; i >= 1 ; i--){
            if(count[i] >= maxVal){
                maxVal = count[i];
                maxIdx = i;
            }
            best[i] = maxIdx;
        }

        int[] answer = new int[starts.length];
        for(int i = 0 ; i < starts.length ; i++){
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}
