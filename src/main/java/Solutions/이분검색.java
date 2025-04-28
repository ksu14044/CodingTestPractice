package Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lt = 0 ;
        int rt = n-1;
        int answer=0;
        while(lt <= rt) {
            int mid = (lt + rt)/2;
            if(arr[mid] == target) {
                answer = mid+1;
                break;
            }
            if(arr[mid] < target) {
                lt = mid + 1;
            } else { rt = mid -1;}
        }
        System.out.println(answer);

    }
}
