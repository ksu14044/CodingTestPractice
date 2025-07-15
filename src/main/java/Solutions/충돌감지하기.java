package Solutions;

import java.util.*;

public class 충돌감지하기 {
    public static class Node {
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object o){
            if(!(o instanceof Node)) return false;
            Node n = (Node) o;
            return x == n.x && y == n.y;
        }

        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
    static List<Node> nodes = new ArrayList<>();
    static List<Node> start = new ArrayList<>();
    static List<Node> end = new ArrayList<>();

    public static void main(String[] args) {
        int[][] points = {
                {3, 2},
                {6, 4},
                {4, 7},
                {1, 4}
        };

        int[][] routes = {
                {4, 2},
                {1, 3},
                {4, 2},
                {4, 3}
        };
        System.out.println(solution(points, routes));
    }
    public static int solution(int[][] points, int[][] routes){
        int n = points.length;
        for(int i = 0 ; i <= n ; i++){
            nodes.add(new Node(-1, -1));
        }

        for(int i = 0 ; i < n ; i++){
            int[] cur = points[i];
            nodes.get(i+1).x = cur[0];
            nodes.get(i+1).y = cur[1];
        }

        for(int i = 0 ; i < routes.length ; i++){
            Node startNode = new Node(nodes.get(routes[i][0]).x, nodes.get(routes[i][0]).y);
            Node endNode = new Node(nodes.get(routes[i][1]).x, nodes.get(routes[i][1]).y);
            start.add(startNode);
            end.add(endNode);
        }
        int count = 0;


        while(!isEquals()){
            count += isConflict(start);
            for(int i = 0 ; i < start.size() ; i++){
                Node cur = start.get(i);
                Node compare = end.get(i);
                if(cur.x != compare.x){
                    cur.x += (cur.x < compare.x) ? 1 : -1;
                }
                else if(cur.y != compare.y){
                    cur.y += (cur.y < compare.y) ? 1 : -1;
                }
            }
        }
        for(int i= start.size() -1 ; i >= 0 ; i--){
            if(start.get(i).equals(end.get(i))){
                start.remove(i);
                end.remove(i);
            }
        }
        count += isConflict(start);

        return count;
    }
    public static boolean isEquals(){
        for(int i = 0 ; i < start.size() ; i++){
            if(!start.get(i).equals(end.get(i))) return false;
        }
        return true;
    }

    public static int isConflict(List<Node> positions){
        Map<Node, Integer> map = new HashMap<>();
        for(Node p : positions){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int count = 0;
        for(int cnt : map.values()){
            if(cnt >= 2) count ++;
        }
        return count;
    }
}
