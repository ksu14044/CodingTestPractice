package Solutions;

public class 안전지대 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {-1, 0, 1, -1, 1, 0, -1, 1};
        boolean[][] isMined = new boolean[board.length][board[0].length];

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] == 1){
                    isMined[i][j] = true;
                    for(int k = 0 ; k < dx.length ; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                            isMined[nx][ny] = true;
                        }
                    }
                }
            }
        }
        int answer = 0;

        for(int i = 0 ; i < isMined.length ; i++){
            for(int j = 0 ; j < isMined[i].length ; j++){
                if(!isMined[i][j]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
