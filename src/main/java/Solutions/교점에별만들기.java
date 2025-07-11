package Solutions;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 교점에별만들기 {
    public static class Point{
        long x, y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(solution(line)));
    }

    public static String[] solution(int[][] line){
        Set<Point> points = new HashSet<>();
        for(int i = 0 ; i < line.length - 1 ; i++){
            for(int j = i + 1 ; j < line.length ; j++){
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];
                long det = a*d - b*c;
                if(det == 0) continue;
                long xNumber = b*f - d*e;
                long yNumber = c*e - a*f;
                if(xNumber % det == 0 && yNumber % det == 0){
                    points.add(new Point(xNumber / det, yNumber / det));
                }
            }
        }
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for(Point p : points){
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        char[][] grid = new char[height][width];
        for(char[] row : grid) Arrays.fill(row, '.');
        for(Point p : points){
            int x = (int)(p.x - minX);
            int y = (int)(maxY - p.y);
            grid[y][x] = '*';
        }
        String[] result = new String[height];
        for(int i = 0 ; i < height ; i++){
            result[i] = new String(grid[i]);
        }
        return result;
    }
}
