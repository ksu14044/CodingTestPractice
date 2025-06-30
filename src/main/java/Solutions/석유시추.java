package Solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 석유시추 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] oilPerCol = new int[m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    int oil = 0;
                    visited[i][j] = true;
                    Set<Integer> set = new HashSet<>();
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        oil += 1;
                        set.add(y);
                        for(int d = 0 ; d < 4 ; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                                if(!visited[nx][ny] && land[nx][ny] == 1){
                                    visited[nx][ny] = true;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    for(int col : set){
                        oilPerCol[col] += oil;
                    }
                }
            }
        }
        int max = 0;
        for(int o : oilPerCol){
            max = Math.max(max, o);
        }
        System.out.println(max);
    }
}
// 실패(효율성 검사 시 시간초과 및 런타임 에러)
//public class Solution {
//    static int[] dx = {-1, 0, 1, 0};
//    static int[] dy = {0, -1, 0, 1};
//    static int max = Integer.MIN_VALUE;
//    public static void main(String[] args) {
//        int[][] land = {
//                {0, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 1, 1, 0, 0},
//                {1, 1, 0, 0, 0, 1, 1, 0},
//                {1, 1, 1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0, 1, 1}
//        };
//
//        for(int i = 0 ; i < land[0].length ; i++){
//            int answer = 0;
//            boolean[][] visited = new boolean[land.length][land[0].length];
//            for(int j = 0 ; j < land.length ; j++){
//                if(!visited[j][i]){
//                    answer += total(land, 1, j, i, visited);
//                }
//            }
//            max = Math.max(max, answer);
//        }
//        System.out.println(max);
//    }
//    public static int total(int[][] land, int sum, int x, int y, boolean[][] visited){
//        if(land[x][y] == 0) return 0;
//        visited[x][y] = true;
//        for(int i = 0 ; i < 4 ; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && !visited[nx][ny] && land[nx][ny] == 1){
//                visited[nx][ny] = true;
//                System.out.println(nx + " " + ny);
//                sum = total(land, sum + land[nx][ny], nx, ny, visited);
//            }
//        }
//        return sum;
//    }
//}
