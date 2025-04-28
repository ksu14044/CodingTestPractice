package Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기_결정알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        int answer = 0;
        while(lt <= rt) {
            int mid = (lt + rt)/2;
            if(count(arr, mid) >= m) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int distance) {
        int cnt = 1;
        int ep = arr[0];
        for(int i = 1 ; i < arr.length; i++) {
            if(arr[i] - ep >= distance) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}
