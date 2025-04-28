package Solutions;

public class 멀리뛰기 {
    public static void main(String[] args) {
        int n = 1000;
        long[] memo = new long[n + 1];
        멀리뛰기 T = new 멀리뛰기();
        System.out.println(T.dfs(n, memo));
    }
    public long dfs (int n, long[] memo){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(memo[n] != 0) return memo[n];
        memo[n] = (dfs(n-1, memo) + dfs(n-2, memo)) % 1234567;
        return memo[n];
    }
}
