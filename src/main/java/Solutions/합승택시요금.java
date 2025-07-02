package Solutions;

import java.util.*;

public class 합승택시요금 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };
        List<List<int[]>> graph = new ArrayList<>();
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
        int[] fromS = dijkstra(graph, s, n);
        int[] fromA = dijkstra(graph, a, n);
        int[] fromB = dijkstra(graph, b, n);

        System.out.println(Arrays.toString(fromS));
        int min = INF;
        for(int i = 1; i <= n ; i++){
            min = Math.min(min, fromS[i] + fromA[i] + fromB[i]);
        }
        System.out.println(min);
    }

    public static int[] dijkstra(List<List<int[]>> graph, int start, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int current = now[0];
            int cost = now[1];
            if(dist[current] < cost) continue;

            for(int[] next : graph.get(current)){
                int nextNode = next[0];
                int nextCost = cost + next[1];
                if(dist[nextNode] > nextCost){
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist;
    }
}
