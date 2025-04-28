package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class 원더랜드최소스패닝트리 {

    static class Edge implements Comparable<Edge>{
        public int v1;
        public int v2;
        public int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }

    static int[] unf;
    public static int Find(int v) {
        if(v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        List<Edge> arr = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) {
            unf[i] = i;
        }
        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Edge(a, b, cost));
        }
        int answer = 0;
        Collections.sort(arr);
        for(Edge e : arr) {
            int fv1 = Find(e.v1);
            int fv2 = Find(e.v2);
            if(fv1 != fv2) {
                answer += e.cost;
                Union(e.v1, e.v2);
            }
        }
        System.out.println(answer);
    }
}
