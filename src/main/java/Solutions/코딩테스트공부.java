package Solutions;

import java.util.Arrays;

public class 코딩테스트공부 {
    public static void main(String[] args) {
        int alp = 10, cop = 10;
        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
        int maxAlp = Integer.MIN_VALUE;
        int maxCop = Integer.MIN_VALUE;
        for(int[] p : problems){
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[alp][cop] = 0;

        alp = Math.min(maxAlp, alp);
        cop = Math.min(maxCop, cop);

        for(int i = alp ; i <= maxAlp ; i++){
            for(int j = cop ; j <= maxCop ; j++){
                int time = dp[i][j];
                if(time == Integer.MAX_VALUE) continue;
                dp[i + 1][j] = Math.min(dp[i + 1][j], time + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], time + 1);
                for(int[] p : problems){
                    if(i >= p[0] && j >= p[1]){
                        int ni = Math.min(maxAlp, i + p[2]);
                        int nj = Math.min(maxAlp, j + p[3]);
                        dp[ni][nj] = Math.min(dp[ni][nj], time + p[4]);
                    }
                }
            }
        }
        System.out.println(dp[maxAlp][maxCop]);
    }
}
