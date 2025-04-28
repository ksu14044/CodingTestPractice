package Solutions;

import java.util.Scanner;

public class 연속된자연수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        int answer = 0;
        n--;
        while ( n > 0) {
            cnt ++;
            n = n - cnt;
            System.out.println("n: "+ n + " cnt: " + cnt);
            if( n % cnt == 0) {
                answer ++;
            }
        }

        System.out.println(answer);

    }
}
