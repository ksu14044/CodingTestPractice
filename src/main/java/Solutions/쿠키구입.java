package Solutions;

public class 쿠키구입 {
    public static void main(String[] args) {
        int[] cookie = {1,1,2,3};
        int answer = 0;
        for(int m = 0 ; m < cookie.length - 1 ; m++){
            int left = m;
            int right = m + 1;

            int leftSum = cookie[left];
            int rightSum = cookie[right];

            while(left >= 0 && right < cookie.length){
                if(leftSum == rightSum){
                    answer = Math.max(answer, leftSum);
                }
                if(leftSum <= rightSum){
                    left--;
                    if(left >= 0) leftSum += cookie[left];
                } else {
                    right++;
                    if(right < cookie.length) rightSum += cookie[right];
                }
            }
        }
        System.out.println(answer);
    }


}
