package Solutions;

import java.util.Scanner;

public class 최대길이연속부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0 ; rt < n ; rt ++){
            if(nums[rt] == 0) {
                cnt++;
            }
            while(cnt > k) {
                if(nums[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        System.out.println(answer);
    }
}
