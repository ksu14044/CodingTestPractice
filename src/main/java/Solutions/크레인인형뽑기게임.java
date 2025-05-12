package Solutions;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int move : moves){
            for(int i = 0 ; i < board.length ; i++){
                if(board[i][move-1] == 0) {
                    continue;
                } else {
                    int picked = board[i][move-1];
                    board[i][move-1] = 0;
                    if(stack.isEmpty()){
                        stack.push(picked);
                        break;
                    } else {
                        if(stack.peek() == picked){
                            stack.pop();
                            count += 2;
                            break;
                        } else {
                            stack.push(picked);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
