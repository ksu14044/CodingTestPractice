package Solutions;

import java.util.*;

public class 리코챗로봇 {
    static class Point{
        int x; int y; int count;
        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static Point start; static Point goal;

    public static void main(String[] args) {
        String[] board = {".D.R", "....", ".G..", "...D"};
        int n = board.length;
        int m = board[0].length();
        String[][] boards = new String[n][m];

        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            String[] b = board[i].split("");
            boards[i] = b;
            for(int j = 0 ; j < m ; j++){
                if(boards[i][j].equals("R")){
                    start = new Point(i, j, 0);
                } else if (boards[i][j].equals("G")) {
                    goal = new Point(i, j, -1);
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == goal.x && cur.y == goal.y){
                System.out.println(cur.count);
                return;
            }
            for(int i = 0 ; i < 4 ; i++){
                int x = cur.x;
                int y = cur.y;

                while(true){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || boards[nx][ny].equals("D")) break;
                    x = nx;
                    y = ny;
                }

                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new Point(x, y, cur.count + 1));
                }
            }
        }
        System.out.println(-1);

    }
}
