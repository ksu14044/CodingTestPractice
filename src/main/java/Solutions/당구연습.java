package Solutions;

import java.util.Arrays;

public class 당구연습 {
    public static void main(String[] args) {
        int m = 10, n = 10;
        int startX = 3, startY = 7;
        int[][] balls = {{7,7}, {2, 7}, {7, 3}};

        int[] answer = new int[balls.length];
        for(int i = 0 ; i < balls.length ; i++){
            int a = balls[i][0];
            int b = balls[i][1];
            int minDist = Integer.MAX_VALUE;
            if(!(startX == a && startY < b)){
                int dx = startX - a;
                int dy = startY - (2 * n - b);
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }
            if(!(startX == a && startY > b)){
                int dx = startX - a;
                int dy = startY - (-b);
                minDist = Math.min(minDist, dx*dx + dy*dy);
            }
            if(!(startY == b && startX > a)){
                int dx = startX - (-a);
                int dy = startY - b;
                minDist = Math.min(minDist, dx*dx + dy*dy);
            }
            if(!(startY == b && startX < a)){
                int dx = startX - (2*m-a);
                int dy = startY - b;
                minDist = Math.min(minDist, dx*dx + dy*dy);
            }

            answer[i] = minDist;
        }
        System.out.println(Arrays.toString(answer));
    }
}
