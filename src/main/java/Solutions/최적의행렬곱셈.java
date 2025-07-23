package Solutions;

public class 최적의행렬곱셈 {
    public static void main(String[] args) {
        int[][] matrix_size = {
                {5, 3},
                {3, 10},
                {10, 6}
        };
        int n = matrix_size.length;
        int[][] dp = new int[n][n];
        int[] size = new int[n + 1];
        for(int i = 0 ; i < n; i++){
            size[i] = matrix_size[i][0];
        }
        size[n] = matrix_size[n-1][1];

        for(int len = 1; len < n ; len++){
            for(int i = 0 ; i + len < n ; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k < j ; k++){
                    int cost = dp[i][k] + dp[k+1][j] + size[i] * size[k+1] * size[j+1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
