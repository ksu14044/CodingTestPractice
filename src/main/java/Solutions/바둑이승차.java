package Solutions;

import java.util.Scanner;

public class 바둑이승차 {
    static int answer = Integer.MIN_VALUE, c, n;
    public static void main(String[] args) {
        바둑이승차 m = new 바둑이승차();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m.dfs(0, 0, arr);
        System.out.println(answer);
    }
    public void dfs(int l, int sum, int[] arr){
        if(sum > c) return;
        if(l==n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(l+1, sum+arr[l], arr);
            dfs(l+1, sum, arr);
        }
    }
}

