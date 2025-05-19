package Solutions;

public class 권투시합 {
    public static void main(String[] args) {
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int n = 5;
        System.out.println(solution(n, result));
    }
    public static int solution(int n, int[][] results) {

        boolean[][] win = new boolean[n+1][n+1];

        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            win[a][b] = true;
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                for(int k = 1; k <= n ; k++){
                    // 순서 중요
                    // 중간에 있는 j가 위에 i를 이기고 그 i가 k를 이겨야 j가 k를 이김
                    if(win[j][i] && win[i][k]){
                        win[j][k] = true;
                    }
                }
            }
        }
        int answer = 0;

        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            for(int j = 1; j <= n ; j++){
                if(i != j){
                    if(win[i][j] || win[j][i]){
                        count++;
                    }
                }
            }
            if(count == n - 1){
                answer++;
            }
        }



        return answer;
    }
}
