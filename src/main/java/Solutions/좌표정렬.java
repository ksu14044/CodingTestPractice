package Solutions;

import java.util.Scanner;

public class 좌표정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        while(cnt < n){
            for(int i = 0; i < n-1; i++) {
                int[] nums = arr[i];
                int[] nums2 = arr[i+1];
                if(nums[0] > nums2[0]) {
                    int[] temp = nums;
                    nums = nums2;
                    nums2 = temp;
                    arr[i] = nums;
                    arr[i+1] = nums2;
                }
                if(nums[0] == nums2[0] && nums[1] > nums2[1]) {
                    int[] temp = nums;
                    nums = nums2;
                    nums2 = temp;
                    arr[i] = nums;
                    arr[i+1] = nums2;
                }
            }
            cnt++;
        }
        for(int[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }

    }
}
