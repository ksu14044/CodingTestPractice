package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 등대 {
    static List<List<Integer>> graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        System.out.println(solution(n, lighthouse));
    }

    public static int solution(int n, int[][] lighthouse){
        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] l : lighthouse){
            graph.get(l[0]).add(l[1]);
            graph.get(l[1]).add(l[0]);
        }
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        dfs(1);

        return Math.min(dp[1][0], dp[1][1]);
    }

    public static void dfs(int node){
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;
        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(next);
                dp[node][0] += dp[next][1];
                dp[node][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }


}
