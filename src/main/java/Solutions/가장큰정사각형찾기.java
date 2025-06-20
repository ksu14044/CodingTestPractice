package Solutions;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        int[][] dp = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == 1){
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer*answer);

    }
}
