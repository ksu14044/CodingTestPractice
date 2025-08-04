package Solutions;

import java.util.Arrays;

public class 단어퍼즐 {
    public static void main(String[] args) {
        String[] strs = {"ba", "na", "n", "a"};
        String t = "banana";
        System.out.println(solution(strs, t));
    }
    public static int solution(String[] strs, String t){
        int n = t.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(String s : strs){
                if(i + s.length() <= n && t.substring(i, i + s.length()).equals(s)){
                    dp[i + s.length()] = Math.min(dp[i + s.length()], dp[i] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
