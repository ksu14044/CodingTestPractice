package Solutions;

public class _3xN타일링 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(solution(18372));
    }
    public static int solution(int n) {
        if (n % 2 == 1) return 0;
        long[] dp = new long[n + 1];
        dp[2] = 3;
        long sum = 0;
        // 점화식 : dp[n] = dp[n-2]*3 + (dp[n-4] + dp[n-6] + ... + dp[0]) * 2;
        for(int i = 4; i <= n ; i += 2){
            dp[i] = (dp[i-2] * 3 + sum*2 + 2) % 1_000_000_007l;
            sum += dp[i-2] % 1_000_000_007l;
        }
        return (int)dp[n];
    }
}
