package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 주사위고르기 {
    static int n;
    static int[][] dice;
    static int[] answer;
    static int[] best;
    static int maxWin;
    public static void main(String[] args) {
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };
        System.out.println(Arrays.toString(solution(dice)));
    }

    public static int[] solution (int[][] diceInput){
        n = diceInput.length;
        dice = diceInput;
        best = new int[n /2];
        maxWin = -1;
        dfs(0, 0, new int[n / 2], new boolean[n]);
        return Arrays.stream(best).map(i -> i + 1).toArray();
    }

    public static void dfs(int depth, int start, int[] picked, boolean[] used){
        if(depth == n / 2){
            List<Integer> aList = getSums(picked);
            List<Integer> bList = getSums(getRemaining(used));
            Collections.sort(bList);

            int winCount = 0;
            for(int aSum : aList){
                int win = upperBound(bList, aSum - 1);
                winCount += win;
            }

            if(winCount > maxWin){
                maxWin = winCount;
                System.arraycopy(picked, 0, best, 0, picked.length);
            }
            return;
        }
        for(int i = start ; i < n ; i++){
            if(!used[i]){
                used[i] = true;
                picked[depth] = i;
                dfs(depth + 1, i + 1, picked, used);
                used[i] = false;
            }
        }
    }

    public static int[] getRemaining(boolean[] used){
        int[] rest = new int[n/2];
        int idx = 0;
        for(int i = 0 ; i < n; i++){
            if(!used[i]){
                rest[idx++] = i;
            }
        }
        return rest;
    }

    public static List<Integer> getSums(int[] dices){
        List<Integer> sums = new ArrayList<>();
        dfsSum(dices, 0, 0, sums);
        return sums;
    }

    public static void dfsSum(int[] dices, int depth, int sum, List<Integer> sums){
        if(depth == dices.length){
            sums.add(sum);
            return;
        }
        for(int i = 0; i < 6 ; i++){
            dfsSum(dices, depth + 1, sum + dice[dices[depth]][i], sums);
        }
    }

    public static int upperBound(List<Integer> list, int target){
        int left = 0, right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}
