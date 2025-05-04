package Solutions;

public class 정수삼각형 {
    // 동적 프로그래밍(DP) => 통과
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(findMaxPath(triangle));
    }

    public static int findMaxPath(int[][] triangle){
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i = n - 2; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}

// 메모이제이션 사용 => 시간 초과 == 재귀 사용 X
//{
//    static Map<String, Integer> memo = new HashMap<>();
//    public static void main(String[] args) {
//        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        System.out.println(findMaxPathSum(triangle, 0, 0));
//    }
//
//    public static int findMaxPathSum(int[][] triangle, int x, int y) {
//        if(x == triangle.length){
//            return 0;
//        }
//        String key = x + "," + y;
//        if(memo.containsKey(key)){
//            return memo.get(key);
//        }
//        int leftPath = findMaxPathSum(triangle, x+1, y);
//        int rightPath = findMaxPathSum(triangle, x+1, y+1);
//        int result = triangle[x][y] + Math.max(leftPath, rightPath);
//        memo.put(key, result);
//        return result;
//    }
//}


// 메모이제이션 사용 x => 시간 초과
//{
//    static int max = Integer.MIN_VALUE;
//    public static void main(String[] args) {
//        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        dfs(triangle, 0, 0, 0, 0);
//        System.out.println(max);
//    }
//
//    public static void dfs(int[][] triangle, int sum, int count, int x, int y){
//        if(count == triangle.length){
//            max = Math.max(sum, max);
//        } else {
//            count++;
//            sum += triangle[x][y];
//            dfs(triangle, sum, count, x+1, y);
//            dfs(triangle, sum, count, x+1, y+1);
//        }
//    }
//}
