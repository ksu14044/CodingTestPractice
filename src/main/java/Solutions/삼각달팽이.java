package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int x = 0, y = 0, direction = 0;

        int num = 1;
        int maxNum = n * (n+1) / 2;

        while(num <= maxNum){
            arr[x][y] = num++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == 0){
                x = nx;
                y = ny;
            } else {
                direction = (direction + 1) % 3;
                x = x + dx[direction];
                y = y + dy[direction];
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int[] a : arr){
            for(int b : a){
                if(b != 0){
                    list.add(b);
                }
            }
        }
        System.out.println(list);
    }
}
