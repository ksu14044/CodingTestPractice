package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int n = maps.length;
        int m = maps[0].length();
        String[][] maps2 = new String[n][m];
        for(int i = 0 ; i < n ; i++){
            String[] b = maps[i].split("");
            maps2[i] = b;
        }
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!maps2[i][j].equals("X") && !visited[i][j]){
                    int[] sum = new int[1];
                    visited[i][j] = true;
                    dfs(maps2, i, j, visited, result, sum);
                    result.add(sum[0]);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
    public static void dfs(String[][] maps2, int x, int y, boolean[][] visited, List<Integer> list, int[] sum){
            sum[0] += Integer.parseInt(maps2[x][y]);
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < maps2.length && ny >= 0 && ny < maps2[0].length && !visited[nx][ny] && !maps2[nx][ny].equals("X")){

                    visited[nx][ny] = true;
                    dfs(maps2, nx, ny, visited, list, sum);
                }
            }

    }
}
