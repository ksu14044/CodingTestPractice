package Solutions;

import java.util.Arrays;

public class _2차원동전뒤집기 {
    public static void main(String[] args) {
        int[][] beginning = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };

        int[][] target = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(solution(beginning, target));
    }

    public static int solution(int[][] beginning, int[][] target){
        int n = beginning.length;
        int m = beginning[0].length;
        int minFlips = Integer.MAX_VALUE;

        for(int rowMask = 0 ; rowMask < ( 1 << n) ; rowMask++){
            int[][] board = copyArray(beginning);
            int flipCount = 0;
            for(int i = 0 ; i < n ; i++){
                if(((rowMask >> i ) & 1) == 1) {
                    flipRow(board, i);
                    flipCount++;
                }
            }

            for(int j = 0 ; j < m ; j ++){
                boolean needFlip = false;
                for(int i = 0 ; i < n ; i++){
                    if(board[i][j] != target[i][j]){
                        needFlip = true;
                        break;
                    }
                }
                if(needFlip){
                    flipCol(board, j);
                    flipCount++;
                }
            }
            if (isSame(board, target)) {
                minFlips = Math.min(minFlips, flipCount);
            }
        }
        return minFlips == Integer.MAX_VALUE ? -1 : minFlips;
    }

    public static int[][] copyArray(int[][] src){
        int[][] copy = new int[src.length][src[0].length];
        for(int i = 0 ; i < src.length ; i++){
            copy[i] = Arrays.copyOf(src[i], src[i].length);
        }
        return copy;
    }

    public static void flipRow(int[][] board, int row){
        for(int j = 0 ; j < board[0].length ; j++){
            board[row][j] ^= 1;
        }
    }

    public static void flipCol(int[][] board, int col){
        for(int i = 0 ; i < board.length ; i++){
            board[i][col] ^= 1;
        }
    }

    public static boolean isSame(int[][] a, int[][] b){
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[i].length ; j++){
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
