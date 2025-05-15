package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리통로_BFS {
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0},{0,1,1,1,1,1,0},{0,0,0,1,0,0,0},{1,1,0,1,0,1,1},{1,1,0,1,0,0,0},{1,0,0,0,1,0,0},{1,0,1,0,0,0,0}};
        int[][] dis = new int[7][7];
        bfs(0,0,board,dis);

        if(dis[6][6] == 0){
            System.out.println(-1);
        } else {
            System.out.println(dis[6][6]);
        }

    }

    public static void bfs(int x, int y, int[][] board, int[][] dis){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        board[x][y] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
}
