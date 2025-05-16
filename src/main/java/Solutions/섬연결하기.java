package Solutions;

import java.util.*;

public class 섬연결하기 {
    private static int[] parent;

    private static int find(int x){
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        int answer = 0;
        int edgesUsed = 0;

        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int bridgeCost = cost[2];

            if(find(a) != find(b)){
                union(a, b);
                answer += bridgeCost;
                edgesUsed++;

                if(edgesUsed == n-1){
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
