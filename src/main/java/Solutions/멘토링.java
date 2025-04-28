package Solutions;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grades = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                grades[i][j] = sc.nextInt();
            }
        }

        int answer = 0 ;
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                int count = 0;
                for(int k = 0 ; k < m; k++) {
                    int pi = 0 , pj = 0;
                    for(int s = 0 ; s < n ; s++) {
                        if(grades[k][s] == i) pi = s;
                        if(grades[k][s] == j) pj = s;
                    }
                    if(pi < pj) count++;
                }
                if(count == m) answer++;
            }
        }
        System.out.println(answer);

    }
}
