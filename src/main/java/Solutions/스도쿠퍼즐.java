package Solutions;

import java.util.Arrays;

public class 스도쿠퍼즐 {
    private static int[][] Board;
    private static class Block {
        int i, j;
        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean inRow(int num, int row){
        return Arrays.stream(Board[row]).anyMatch(n -> n == num);
    }

    private static boolean inCol(int num, int col){
        for(int i = 0 ; i < 9 ; i++){
            if(Board[i][col] == num) return true;
        }
        return false;
    }

    private static boolean inBox(int num, int row, int col){
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for(int i = boxRow ; i < boxRow + 3 ; i++){
            for(int j = boxCol ; j < boxCol + 3 ; j++){
                if(Board[i][j] == num) return true;
            }
        }
        return false;
    }

    private static boolean isValid(int num, int row, int col){
        return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col));
    }

    private static Block getEmpty(){
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j ++){
                if(Board[i][j] == 0) return new Block(i, j);
            }
        }
        return null;
    }

    private static boolean findSolution(){
        Block emptyPos = getEmpty();
        if(emptyPos == null) return true;
        int row = emptyPos.i;
        int col = emptyPos.j;
        for(int num = 1 ; num <= 9 ; num++){
            if(isValid(num, row, col)){
                Board[row][col] = num;
                if(findSolution()) return true;
                Board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9];
        Board = board;
        findSolution();
        for(int[] b : board){
            System.out.println(Arrays.toString(b));
        }
    }
}
