package Solutions;

import java.util.Arrays;

public class 과일장수 {
    public static void main(String[] args) {
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        int k = 3;
        int m = 4;
        Arrays.sort(score);
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int a : score){
            System.out.print(a + " ");
        }
        for(int i = score.length -1 ; i >= m - 1 ; i -= m){
            for(int j = i ; j > i - m ; j--){
                min = Math.min(min, score[j]);
            }
            answer += min * m;
            System.out.println(answer);
        }
        System.out.println(answer);

    }
}
