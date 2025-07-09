package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        visited = new boolean[m][n];
        int[][] pictures = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int area = 0;
        int maxSize = 0;
        for(int i = 0 ; i < pictures.length ; i++){
            for(int j = 0 ; j < pictures[i].length ; j++){
                if(!visited[i][j] && pictures[i][j] != 0){
                    int size = bfs(i, j, pictures[i][j], m, n, pictures);
                    area++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(area + " " + maxSize);
    }

    public static int bfs(int x, int y, int color, int m ,int n, int[][] pictures){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if(!visited[nx][ny] && pictures[nx][ny] == color){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
