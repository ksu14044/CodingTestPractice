package Solutions;

import java.util.*;

public class 등산코스정하기 {
    public static class Node implements Comparable<Node> {
        int idx, intensity;
        public Node(int idx, int intensity){
            this.idx = idx;
            this.intensity = intensity;
        }
        public int compareTo(Node other){
            return this.intensity - other.intensity;
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] paths = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 4, 2},
                {2, 5, 4},
                {3, 4, 4},
                {4, 5, 3},
                {4, 6, 1},
                {5, 6, 1}
        };
        int[] gates = {1,3};
        int[] summits = {5};
        System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits){
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        for(int gate : gates) gateSet.add(gate);
        for(int summit : summits) summitSet.add(summit);

        for(int[] path : paths){
            int from = path[0], to = path[1], cost = path[2];
            if(gateSet.contains(from) || summitSet.contains(to)){
                graph.get(from).add(new int[]{to, cost});
            } else if(gateSet.contains(to) || summitSet.contains(from)){
                graph.get(to).add(new int[]{from, cost});
            } else {
                graph.get(from).add(new int[]{to, cost});
                graph.get(to).add(new int[]{from, cost});
            }
        }

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int gate : gates){
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.idx;
            int cost = cur.intensity;
            if(intensity[now] < cost) continue;
            if(summitSet.contains(now)) continue;

            for(int[] next : graph.get(now)){
                int nextNode = next[0];
                int weight = Math.max(cost, next[1]);
                if(intensity[nextNode] > weight){
                    intensity[nextNode] = weight;
                    pq.offer(new Node(nextNode, weight));
                }
            }
        }
        Arrays.sort(summits);
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        for(int summit : summits){
            if(intensity[summit] < minIntensity){
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }
        return new int[]{minSummit, minIntensity};
    }
}
