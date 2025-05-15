package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토백준버전 {
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board, dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        board = new int[m][n];
        dis = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        bfs();
        int max = Integer.MIN_VALUE;
        for(int[] a : dis){
            for(int b : a){
                max = Math.max(max, b);
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 0 && dis[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();
        for(int i = 0 ; i < board.length ; i ++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] == 1){
                    q.offer(new Point(i, j));
                }
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4 ; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
}
