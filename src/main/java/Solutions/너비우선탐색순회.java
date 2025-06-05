package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 너비우선탐색순회 {
    public static void main(String[] args) {
        int[][] graph = {{1,3},{3,4},{3,5},{5,2}};
        int start = 1;
        int n = 5;
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.length ; i++){
            list.get(graph[i][0]).add(graph[i][1]);
        }
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            answer.add(cur);
            for(int i = 0 ; i < list.get(cur).size() ; i++){
                if(!visited[list.get(cur).get(i)]){
                    visited[list.get(cur).get(i)] = true;
                    q.offer(list.get(cur).get(i));
                }
            }
        }
        System.out.println(answer);
    }
}
