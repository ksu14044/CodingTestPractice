package Solutions;

import java.util.Arrays;

public class 정수를나선형으로배치하기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int n = 4;
        int[][] answer = new int[n][n];
        dfs(answer, 0, 0, 1, 0);
        for(int[] a : answer){
            System.out.println(Arrays.toString(a));
        }
    }

    public static void dfs(int[][] answer, int x, int y, int n, int dir){
        if(n > (answer.length + 1) * (answer.length+1)){
            return;
        }
        answer[x][y] = n;
        int nx = x + dx[dir % 4];
        int ny = y + dy[dir % 4];
        if( nx < 0 || ny < 0 || nx >= answer.length || ny >= answer.length || answer[nx][ny] != 0){
            dir++;
            nx = x + dx[dir % 4];
            ny = y + dy[dir % 4];
        }
        if(nx >= 0 && nx < answer.length && ny >= 0 && ny < answer.length && answer[nx][ny] == 0){
            dfs(answer, nx, ny, n+1, dir);
        }
    }

}
