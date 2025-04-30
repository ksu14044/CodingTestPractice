package Solutions;

public class 소수만들기 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        소수만들기 T = new 소수만들기();
        int count = 0;
        for(int i = 0 ; i < nums.length - 2 ; i++){
            for(int j = i+1 ; j < nums.length - 1 ; j++){
                for(int k = j+1 ; k < nums.length ; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(T.isPrime(sum)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public boolean isPrime (int n) {
        for(int i = 2 ; i < n/2 ; i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
