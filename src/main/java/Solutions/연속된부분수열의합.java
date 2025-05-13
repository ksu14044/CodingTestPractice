package Solutions;

import java.util.Arrays;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1,2,3,4,5};
        int k = 7;
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(start <= end && end < sequence.length) {
            if(sum == k){
                if((end - start) < minLength) {
                    minLength = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            } else if( sum < k ){
                end++;
                if(end < sequence.length) {
                    sum += sequence[end];
                }
            } else {
                sum -= sequence[start];
                start++;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
