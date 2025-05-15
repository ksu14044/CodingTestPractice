package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 토마토_BFS활용 {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] box = {{0,0,-1,0,0,0},{0,0,1,0,-1,0},{0,0,-1,0,0,0},{0,0,0,0,-1,1}};
        int[][] dis = new int[box.length][box[0].length];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0 ; i < box.length ; i++){
            for(int j = 0 ; j < box[0].length ; j++){
                if(box[i][j] == 1){
                    q.offer(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < box.length && ny >= 0 && ny < box[0].length && box[nx][ny] == 0){
                    box[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] a : dis){
            for(int b : a){
                max = Math.max(max, b);
            }
        }
        System.out.println(max);
    }
}
