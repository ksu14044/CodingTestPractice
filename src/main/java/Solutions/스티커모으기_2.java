package Solutions;

import java.util.Arrays;

public class 스티커모으기_2 {
    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        int n = sticker.length;
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for(int i = 2 ; i < n - 1 ; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2 ; i < n ; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));
        int answer = Math.max(dp1[n-2], dp2[n-1]);
        System.out.println(answer);
    }
}
