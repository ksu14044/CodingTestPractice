package Solutions;

import java.util.*;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        int[] dx  = {-1, 0, 1, 0};
        int[] dy =  {0, 1, 0, -1};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k = 0 ; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >=0 && nx < n && ny >= 0 && ny < n && matrix[nx][ny] >= matrix[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) { answer ++;}
            }
        }
        System.out.println(answer);

    }
}
