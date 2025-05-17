package Solutions;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;

        System.out.println(solution(n, vertex));
    }

    public static int solution(int n , int[][] vertex){
        int count = 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] v : vertex){
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph.get(cur)){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int maxDist = Integer.MIN_VALUE;
        for(int a : dist){
            maxDist = Math.max(maxDist, a);
        }

        for(int a : dist){
            if(a == maxDist){
                count++;
            }
        }
        return count;
    }
}
