package Solutions;

public class 완전범죄 {
    public static void main(String[] args) {
        int[][] info = {{1,2}, {2,3}, {2,1}};
        int n = 4;
        int m = 4;
        System.out.println(solution(info, n , m));
    }
    public static int solution(int[][] info, int n, int m){
        int len = info.length;
        boolean[][][] dp = new boolean[len+1][n][m];
        dp[0][0][0] = true;

        for(int i = 0 ; i < len ; i++){
            for(int a = 0 ; a < n ; a++){
                for(int b = 0 ; b < m ; b++){
                    if(!dp[i][a][b]) continue;

                    int traceA = info[i][0];
                    int traceB = info[i][1];

                    if(a + traceA < n){
                        dp[i+1][a+traceA][b] = true;
                    }
                    if(b + traceB < m){
                        dp[i+1][a][b+traceB] = true;
                    }
                }
            }
        }
        for(int a = 0 ; a < n ; a++){
            for(int b = 0 ; b < m ; b++){
                if(dp[len][a][b]) return a;
            }
        }
        return -1;
    }
}
// 틀림 그래도 비트마스크를 이용한 부분집합 구하는 함수 참고
//public class Solution {
//    static List<List<Integer>> combi = new ArrayList<>();
//    public static void main(String[] args) {
//        int[][] info = {{1,2}, {2,3}, {2,1}};
//        int n = 4;
//        int m = 4;
//        int N = n;
//        int M = m;
//        int total = 1 << info.length;
//        for(int i = 0 ; i < total ; i++){
//            List<Integer> arr = new ArrayList<>();
//            for(int j = 0 ; j < info.length ; j++){
//                if((i & (1 << j)) != 0){
//                    arr.add(j);
//                }
//            }
//            combi.add(new ArrayList<>(arr));
//        }
//        combi.remove(0);
//        int answer = -1;
//        for(int i = 0 ; i < combi.size() ; i++){
//            n = N;
//            m = M;
//            List<Integer> cur = combi.get(i);
//            for(int j = 0 ; j < info.length ; j++){
//                if(cur.contains(j)){
//                    n -= info[j][0];
//                } else m -= info[j][1];
//            }
//            if(n > 0 && m > 0){
//                answer = answer < 0 ? N - n : Math.min(answer, N - n);
//            }
//        }
//        System.out.println(answer);
//    }
//}
