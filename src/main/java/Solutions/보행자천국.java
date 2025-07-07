package Solutions;

import java.util.Arrays;

public class 보행자천국 {

    public static void main(String[] args) {
        int m = 3;
        int n = 6;
        int[][] cityMap = {
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        };
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(cityMap[i][j] == 1) continue;
                if( i > 0 && cityMap[i-1][j] != 1){
                    if (cityMap[i - 1][j] == 0) {
                        dp[i][j] += dp[i-1][j];
                    } else if(cityMap[i-1][j] == 2 && j > 0 && cityMap[i][j-1] != 1){
                        dp[i][j] += dp[i-1][j];
                    }
                }
                if( j > 0 && cityMap[i][j -1] != 1){
                    if(cityMap[i][j-1] == 0){
                        dp[i][j] += dp[i][j-1];
                    } else if(cityMap[i][j-1] == 2 && i > 0 && cityMap[i-1][j] != 1){
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }
}
