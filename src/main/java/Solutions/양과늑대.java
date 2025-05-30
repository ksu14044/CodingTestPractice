package Solutions;

import java.util.*;

public class 양과늑대 {
    // DFS
    public static List<List<Integer>> tree = new ArrayList<>();
    public static int maxSheep = 0;

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        for(int i = 0 ;i < info.length; i++) tree.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++) tree.get(edges[i][0]).add(edges[i][1]);

        List<Integer> nextNode = new ArrayList<>();
        nextNode.add(0);
        dfs(0, 0, 0, nextNode, info);
        System.out.println(maxSheep);
    }

    public static void dfs(int node, int sheep, int wolf, List<Integer> nextNodes, int[] info){
        if(info[node] == 0) sheep++;
        else wolf++;
        if(sheep <= wolf) return;
        maxSheep = Math.max(maxSheep, sheep);
        List<Integer> candidates = new ArrayList<>(nextNodes);
        candidates.remove(Integer.valueOf(node));
        candidates.addAll(tree.get(node));

        for(int next : candidates){
            dfs(next, sheep, wolf, candidates, info);
        }
    }
}
// BFS
//    static List<List<Integer>> tree = new ArrayList<>();
//    static class Info {
//        int node, sheep, wolf;
//        Set<Integer> visited;
//        public Info(int node, int sheep, int wolf, Set<Integer> visited) {
//            this.node = node;
//            this.sheep = sheep;
//            this.wolf = wolf;
//            this.visited = visited;
//        }
//    }
//    public static void main(String[] args) {
//        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
//        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
//        generateTree(info, edges);
//        int answer = 0;
//        Queue<Info> q = new LinkedList<>();
//        q.offer(new Info(0, 1, 0, new HashSet<>()));
//
//        while(!q.isEmpty()){
//            Info now = q.poll();
//            answer = Math.max(answer, now.sheep);
//            now.visited.addAll(tree.get(now.node));
//
//            for(int next : now.visited){
//                Set<Integer> set = new HashSet<>(now.visited);
//                set.remove(next);
//
//                if(info[next] == 1){
//                    if(now.sheep != now.wolf + 1){
//                        q.offer(new Info(next, now.sheep, now.wolf + 1, set));
//                    }
//                } else q.offer(new Info(next, now.sheep + 1, now.wolf, set));
//            }
//        }
//        System.out.println(answer);
//    }
//
//    public static void generateTree(int[] info, int[][] edges){
//        for(int i = 0 ; i < info.length ; i++){
//            List<Integer> list = new ArrayList<>();
//            tree.add(list);
//        }
//        for(int[] edge : edges){
//            tree.get(edge[0]).add(edge[1]);
//        }
//    }
//}
