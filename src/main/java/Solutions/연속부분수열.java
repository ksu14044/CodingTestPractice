package Solutions;

import java.util.Scanner;

public class 연속부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        int p = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum > target && p <= i){
                sum -= nums[p];
                p++;
            }
            if( sum == target) {
                count++;
            }
        }
        System.out.println(count);
    }
}
