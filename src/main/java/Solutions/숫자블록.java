package Solutions;

import java.util.Arrays;

public class 숫자블록 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        System.out.println(Arrays.toString(solution(begin, end)));
    }

    public static int[] solution(long begin, long end){
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];
        for(int i = 0 ; i < len ; i++){
            long num = i + begin;
            answer[i] = getBlock(num);
        }
        return answer;
    }

    public static int getBlock(long num){
        if(num == 1) return 0;
        int result = 1;
        for(long i = 2 ; i*i <= num ; i++){
            if(num % i == 0){
                long paired = num / i;
                if(paired <= 10_000_000) return (int)paired;
                if(i <= 10_000_000) result = (int)i;
            }
        }
        return result;
    }
}
