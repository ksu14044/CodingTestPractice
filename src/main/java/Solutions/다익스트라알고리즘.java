package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 다익스트라알고리즘 {
    public static class Node {
        int dest; int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{0,1,9},{0,2,3},{1,0,5},{2,1,1}};
        int start = 0;
        int n = 3;
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] g : graph){
            list.get(g[0]).add(new Node(g[1], g[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.dest] < cur.cost){
                continue;
            }
            for(Node next : list.get(cur.dest)){
                if(dist[next.dest] > cur.cost + next.cost){
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
