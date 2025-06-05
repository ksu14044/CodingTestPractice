package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 깊이우선탐색순회 {
    public static void main(String[] args) {
        int[][] graph = {{1,2}, {1,3}, {2,4},{2,5},{3,6},{5,6}};
        int start = 1;
        int n  = 6;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] g : graph){
            list.get(g[0]).add(g[1]);
        }
        boolean[] visited = new boolean[n + 1];
        List<Integer> answer = new ArrayList<>();
        dfs(list, start, answer, visited);
        System.out.println(answer);


    }

    public static void dfs(List<List<Integer>> list, int num, List<Integer> answer, boolean[] visited){
        visited[num] = true;
        answer.add(num);
        List<Integer> l = list.get(num);
        for(int i = 0 ; i < l.size() ; i++){
            if(!visited[l.get(i)]){
                dfs(list, l.get(i), answer, visited);
            }
        }
    }
}
