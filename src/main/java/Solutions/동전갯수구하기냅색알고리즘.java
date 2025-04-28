package Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class 동전갯수구하기냅색알고리즘 {
    static int n, m;
    static int[] dy;
    public int solution (int[] arr) {
        int answer = 0;
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <=m ; j++) {
                dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        동전갯수구하기냅색알고리즘 T = new 동전갯수구하기냅색알고리즘();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];
        System.out.println(T.solution(arr));
    }
}
