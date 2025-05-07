package Solutions;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i = 0 ;i < 4; i++){
            dp[n-1][i] = land[n-1][i];
        }
        for(int i = dp.length - 1; i >= 1 ; i--){
            for(int j = 0 ; j < 4; j++){
                for(int k = 0 ; k < 4; k++){
                    if(j != k){
                        dp[i-1][j] = Math.max(dp[i-1][j], dp[i][k] + land[i-1][j]);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < 4; i++){
            max = Math.max(dp[0][i], max);
        }
        System.out.println(max);
    }
}
