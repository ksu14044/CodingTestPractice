package Solutions;

import java.util.Scanner;

public class 조합의경우수_메모이제이션 {
    public static void main(String[] args) {
        조합의경우수_메모이제이션 m = new 조합의경우수_메모이제이션();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(m.dfs(n, r));;
    }
    int[][] dy = new int[35][35];
    public int dfs(int n, int r) {
        if(dy[n][r] > 0) { return dy[n][r]; }
        if(n == r || r == 0) {
            return 1;
        }
        else return dy[n][r] = dfs(n - 1, r-1) + dfs(n-1, r);
    }
}
