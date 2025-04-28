package Solutions;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i = 0 ; i < m ; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cache = new int[n];
        for(int x : arr) {
            int pos = -1;
            for(int i = 0 ; i < n ; i++) {
                if( x == cache[i]) {
                    pos = i;
                }
            }
            if(pos == -1) {
                for (int i = n - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for ( int i = pos ; i >= 1 ; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        for(int a : cache) {
            System.out.print(a+" ");
        }

    }
}
