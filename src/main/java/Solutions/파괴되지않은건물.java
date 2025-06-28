package Solutions;

// 누적합 알고리즘
class 파괴되지않은건물 {
    public static void main(String[] args) {
        int[][] board = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}
        };

        int[][] skill = {
                {1, 0, 0, 3, 4, 4},
                {1, 2, 0, 2, 3, 2},
                {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}
        };
        System.out.println(solution(board, skill));
    }

    public static int solution(int[][] board, int[][] skill){
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 2][m + 2];

        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            int delta = (type == 1) ? -degree : degree;
            diff[r1][c1] += delta;
            diff[r1][c2+1] -= delta;
            diff[r2+1][c1] -= delta;
            diff[r2+1][c2+1] += delta;
        }

        for(int i = 0 ; i < n + 1 ; i++){
            for(int j = 1 ; j < m + 1 ; j++){
                diff[i][j] += diff[i][j - 1];
            }
        }
        for(int j = 0 ; j < m + 1 ; j++){
            for(int i = 1; i < n + 1 ; i++){
                diff[i][j] += diff[i-1][j];
            }
        }
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] + diff[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
// 시간초과
//class Solution {
//    public int solution(int[][] board, int[][] skill) {
//        int answer = 0;
//        for(int[] s : skill){
//            if(s[0] == 1){
//                destroy(board, s[1],s[2],s[3],s[4],s[5]);
//            } else if(s[0] == 2){
//                heal(board, s[1],s[2],s[3],s[4],s[5]);
//            }
//        }
//        for(int i = 0 ; i < board.length ; i++){
//            for(int j = 0 ; j < board[i].length ; j++){
//                if(board[i][j] > 0) answer++;
//            }
//        }
//        return answer;
//    }
//
//    public void destroy(int[][] board, int r1, int c1, int r2, int c2, int degree){
//        for(int i = r1 ; i <= r2 ; i++){
//            for(int j = c1 ; j <= c2 ; j++){
//                board[i][j] -= degree;
//            }
//        }
//    }
//
//    public void heal(int[][] board, int r1, int c1, int r2, int c2, int degree){
//        for(int i = r1 ; i <= r2 ; i++){
//            for(int j = c1 ; j <= c2 ; j++){
//                board[i][j] += degree;
//            }
//        }
//    }
//}
