package Solutions;

import java.util.Scanner;

public class 수열추측하기 {
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] > 0) { return dy[n][r]; }
        if(n == r || r == 0) {
            return 1;
        } else {
           return  dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public void dfs(int l, int sum){
        if(flag) return;
        if(l == n) {
            if(sum == f){
                for(int x : p) {
                    System.out.print(x+" ");
                    flag = true;
                }
            }
        } else {
            for(int i = 1 ; i <= n ; i++ ) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + p[l] * b[l]);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        수열추측하기 m = new 수열추측하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b= new int[n];
        p= new int[n];
        ch = new int[n+1];
        for(int i = 0; i < n; i++) {
            b[i] = m.combi(n-1, i);
        }
        m.dfs(0,0);
    }
}
