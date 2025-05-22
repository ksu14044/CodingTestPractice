package Solutions;

import java.util.*;

public class 배달 {

    public static class Node {
        int node;
        int dist;
        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 5;
        int K = 3;

        List<List<Node>> graph = new ArrayList<List<Node>>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] r : road){
            int a = r[0]; int b = r[1]; int c = r[2];
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        int[] minTime = new int[N+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.node;
            int curDist = cur.dist;
            if(curDist > minTime[curNode]) continue;
            for(Node next : graph.get(curNode)){
                int newDist = next.dist + curDist;
                if(newDist < minTime[next.node]){
                    minTime[next.node] = newDist;
                    pq.offer(new Node(next.node, newDist));
                }
            }
        }
        int count = 0;
        for(int i = 1 ; i <= N ; i++){
            if(minTime[i] <= K) count++;
        }
        System.out.println(count);
    }
}
