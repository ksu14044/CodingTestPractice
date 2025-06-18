package Solutions;

import java.util.*;

public class 부대복귀 {
    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1,2}, {2,3}};
        int[] sources = {2,3};
        int destination = 1;
        System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph.get(cur)){
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}
