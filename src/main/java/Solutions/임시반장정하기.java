package Solutions;

import java.util.*;

public class 임시반장정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] students = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                students[i][j] = sc.nextInt();
            }
        }
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n ; j++){
                for(int k = 1; k < 6 ; k++) {
                    if(students[i][k] == students[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }
        System.out.println(answer);


    }
}
