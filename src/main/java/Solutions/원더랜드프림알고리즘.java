package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 원더랜드프림알고리즘 {
    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;
        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<List<Edge>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        int[] ch = new int[n+1];
        for(int i = 0 ; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int ev = tmp.vex;
            if(ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for(Edge edge : graph.get(ev)) {
                    if(ch[edge.vex] == 0) {
                        pq.offer(new Edge(edge.vex, edge.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
