package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 바탕화면정리 {
    public static class Point{
        int x; int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        String[][] s = new String[n][m];
        for(int i = 0 ; i < n ; i++){
            String[] wp = wallpaper[i].split("");
            for(int j = 0 ; j < m ; j++){
                s[i][j] = wp[j];
            }
        }
        List<Point> points = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(s[i][j].equals("#")){
                    points.add(new Point(i, j));
                }
            }
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(Point p : points){
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        int[] answer = new int[4];
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        System.out.println(Arrays.toString(answer));
    }
}
