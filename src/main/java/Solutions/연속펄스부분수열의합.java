package Solutions;

public class 연속펄스부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {2,3,-6,1,3,-1,2,4};
        System.out.println(solution(sequence));
    }
    public static long solution(int[] sequence) {
        long sum1 = 0;
        long sum2 = 0;
        long max1 = Long.MIN_VALUE; long max2 = Long.MIN_VALUE;
        for(int i = 0 ; i < sequence.length ; i++){
            int sign1 = (i % 2 == 0) ? 1 : -1;
            int sign2 = -sign1;
            sum1 = Math.max((long)sequence[i]*sign1, sum1 + (long)sequence[i] * sign1);
            sum2 = Math.max((long)sequence[i]*sign2, sum2 + (long)sequence[i] * sign2);
            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);
        }
        return Math.max(max1, max2);
    }


}
