package Solutions;

import java.util.Scanner;

public class 섬나라아일랜드 {
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!isVisited[i][j] && board[i][j] == 1){
                    count++;
                    dfs(board, isVisited, i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] board, boolean[][] isVisited, int x, int y){
        isVisited[x][y] = true;
        for(int i = 0 ; i < 8 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 1){
                board[nx][ny] = 0;
                dfs(board, isVisited, nx, ny);
            }
        }
    }
}
