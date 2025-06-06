package Solutions;

import java.util.Scanner;

public class 친구인가 {
    static int[] unf;
    public static int Find(int i) {
        if(i == unf[i]) return i;
        else return unf[i] = Find(unf[i]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for( int i = 1 ; i <= n ; i++) unf[i] = i;
        for( int j = 1 ; j <= m ; j++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a,b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
