package Solutions;

import java.util.Scanner;

public class 합이같은부분집합 {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;
    public static void main(String[] args) {
        합이같은부분집합 obj = new 합이같은부분집합();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for(int a : arr) {
            sum += a;
        }
        if(sum % 2 != 0 ) {
            answer = "NO";
            System.out.println(answer);
            return;
        }
        obj.dfs(0, 0, arr);
        System.out.println(answer);
    }

    public void dfs(int l, int sum, int[] arr){
        if(flag) return;
        if(sum > total/2) return;
        if(l == n) {
            if((total-sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(l+1, sum+arr[l], arr);
            dfs(l+1, sum, arr);
        }
    }

}
