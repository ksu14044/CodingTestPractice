package Solutions;

public class 이웃한칸 {
    public static void main(String[] args) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        int answer = 0;
        for(int i = 0 ; i < dx.length ; i++){
            int nh = h + dx[i];
            int nw = w + dy[i];
            if(nh >= 0 && nh < board.length && nw >= 0 && nw < board[0].length){
                if(board[nh][nw].equals(board[h][w])){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
