package Solutions;

import java.util.Arrays;

public class 미사일요격하기 {
    public static void main(String[] args) {
        int[][] targets = {
                {4, 5},
                {4, 8},
                {10, 14},
                {11, 13},
                {5, 12},
                {3, 7},
                {1, 4}
        };
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int lastShot = Integer.MIN_VALUE;
        int answer = 0;
        for(int[] target : targets){
            int start = target[0];
            int end = target[1];
            if(start > lastShot){
                lastShot = end - 1;
                answer ++;
            }
        }
        System.out.println(answer);
    }
}
