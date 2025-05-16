package Solutions;

import java.util.*;

public class 전력망둘로나누기 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires){

        int min = Integer.MAX_VALUE;
        for(int[] wire : wires){
            Map<Integer, List<Integer>> graph = buildGraph(n, wires);
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            Set<Integer> isVisited = new HashSet<>();
            int networkSize = bfs(graph, wire[0], isVisited);
            int difference = Math.abs(networkSize - (n - networkSize));
            min = Math.min(min, difference);
        }
        return min;
    }

    public static Map<Integer, List<Integer>> buildGraph(int n, int[][] wires) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return graph;
    }

    public static int bfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> isVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited.add(start);
        int count = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbor : graph.get(node)){
                if(!isVisited.contains(neighbor)){
                    q.add(neighbor);
                    isVisited.add(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}
