package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    public static class Point{
        int x, y, dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int n = maps.length;
        int m = maps[0].length();
        Point startPoint = null; Point endPoint = null; Point lavorPoint = null;
        char[][] charMap = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            charMap[i] = maps[i].toCharArray();
            for(int j = 0 ; j < m ; j++){
                if(charMap[i][j] == 'S') startPoint = new Point(i, j, 0);
                else if(charMap[i][j] == 'E') endPoint = new Point(i, j, 0);
                else if(charMap[i][j] == 'L') lavorPoint = new Point(i, j, 0);
            }
        }
        int toLavor = bfs(charMap, startPoint, lavorPoint);
        int toEnd = bfs(charMap, lavorPoint, endPoint);
        if(toLavor == -1 || toEnd == -1){
            System.out.println(-1);
            return;
        } else {
            System.out.println(toLavor + toEnd);
        }
    }

    public static int bfs(char[][] map , Point start, Point target){
        int n = map.length ; int m = map[0].length ;
        boolean[][] isVisited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        isVisited[start.x][start.y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == target.x && cur.y == target.y){return cur.dist;}
            for(int i = 0 ; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if( nx >= 0  && nx < n && ny >= 0 && ny < m && !isVisited[nx][ny] && map[nx][ny] != 'X'){
                    q.offer(new Point(nx, ny, cur.dist + 1));
                    isVisited[nx][ny] = true;
                }
            }
        }
        return -1;
    }


}
