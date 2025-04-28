package Solutions;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = sc.nextInt()-1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int cnt = 0;
        for(int i = 0 ; i < moves.length ; i++) {
            for(int j = 0; j < board.length ; j++) {
                if(board[j][moves[i]] != 0) {
                    if(stack.lastElement() != board[j][moves[i]]) {
                        stack.push(board[j][moves[i]]);
                    } else {
                        stack.pop();
                        cnt += 2;
                    }
                    board[j][moves[i]] = 0;
                    break;
                }
            }
        }

        System.out.println(cnt);


    }
}
