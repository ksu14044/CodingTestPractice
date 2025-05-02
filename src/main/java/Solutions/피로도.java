package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 피로도 {
    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        int k = 80;
        int[] test = new int[dungeons.length];
        for(int i = 0 ; i < test.length; i++) {
            test[i] = i;
        }
        int max = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[test.length];
        dfs(test, new ArrayList<>(), isVisited, result);


        for(List<Integer> temp : result) {
            int count = 0;
            int k2 = k;
            for(int i : temp) {
                if(dungeons[i][0] <= k2){
                    count++;
                    k2 -= dungeons[i][1];
                    max = Math.max(max, count);
                } else {
                    break;
                }
            }
        }
        System.out.println(max);


    }

    public static void dfs(int[] arr, List<Integer> temp, boolean[] isVisited, List<List<Integer>> result){
        if(temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for(int i = 0 ; i < arr.length; i++){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    temp.add(arr[i]);
                    dfs(arr, temp, isVisited, result);
                    temp.remove(temp.size() - 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
