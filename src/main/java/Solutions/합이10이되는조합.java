package Solutions;

import java.util.ArrayList;
import java.util.List;

public class 합이10이되는조합 {
    static List<List<Integer>> result;
    static int n;
    public static void main(String[] args) {
        int N = 7;
        n = N;
        result = new ArrayList<>();
        backTrack(0, new ArrayList<>(), 1);
        System.out.println(result);
    }

    public static void backTrack(int sum, List<Integer> selectedNums, int start){
        if(sum == 10){
            result.add(selectedNums);
            return;
        }
        for(int i = start ; i <= n ; i++){
            if(sum + i <= 10){
                List<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backTrack(sum + i, list, i + 1);
            }
        }
    }
}
